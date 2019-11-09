package com.football.pl_fixture.ui.fixture

import android.view.View
import androidx.annotation.VisibleForTesting
import androidx.lifecycle.MutableLiveData
import com.football.pl_fixture.R
import com.football.pl_fixture.data.locale.room.doa.MatchesDoa
import com.football.pl_fixture.data.model.MatchesItem
import com.football.pl_fixture.data.services.FixtureAPI
import com.football.pl_fixture.ui.base.BaseViewModel
import com.football.pl_fixture.utils.ioThread
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class FixtureViewModel(private val api: FixtureAPI, private val matchesDoa: MatchesDoa) :
        BaseViewModel(), OnFavouriteClickListener {

    val adapter: FixtureAdapter = FixtureAdapter(this)
    val loadingVisibility: MutableLiveData<Boolean> = MutableLiveData()
    val errorMassage: MutableLiveData<Int> = MutableLiveData()
    val errorClickListener = View.OnClickListener { fetchMatches() }
    val isFavouriteChose: MutableLiveData<Boolean> = MutableLiveData()

    init {
        fetchMatches()
    }

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    fun fetchMatches() {
        launch {
            Observable.fromCallable { matchesDoa.getAllMatches }
                    .concatMap { dbMatchesList ->
                        if (dbMatchesList.isEmpty()) {
                            api.getMatches().concatMap { apiMatchesList ->
                                matchesDoa.insert(*apiMatchesList.matches.toTypedArray())
                                Observable.just(apiMatchesList.matches)
                            }
                        } else {
                            Observable.just(dbMatchesList)
                        }
                    }
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doFinally { loadingVisibility.value = true }
                    .doOnSubscribe { loadingVisibility.value = false }
                    .subscribe({ onFetchingListSuccess(it) }, { errorMassage.value = R.string.cant_load_data })
        }
    }

    override fun onFavouriteClicked(matchesItem: MatchesItem) {
        matchesItem.isFavourite = matchesItem.isFavourite.not()
        ioThread { matchesDoa.insert(matchesItem) }
    }

    fun getFavourites() {
        launch {
            Observable.fromCallable { matchesDoa.getFavouriteMatches }
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        adapter.addMatches(it)
                    }
        }
    }

    fun getAllMatches() {
        launch {
            Observable.fromCallable { matchesDoa.getAllMatches }
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        adapter.addMatches(it)
                    }
        }
    }

    private fun onFetchingListSuccess(matches: List<MatchesItem>) {
        adapter.addMatches(matches)
    }
}