package com.siifii.pl_fixture.ui.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BaseViewModel : ViewModel() {

    private val disposables = CompositeDisposable()

    fun launch(job: () -> Disposable) {
        disposables.addAll(job())
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}