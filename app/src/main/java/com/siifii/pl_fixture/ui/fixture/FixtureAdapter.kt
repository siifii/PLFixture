package com.siifii.pl_fixture.ui.fixture

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.siifii.pl_fixture.databinding.ListItemMatchesDateBinding
import com.siifii.pl_fixture.data.model.MatchesItem
import com.siifii.pl_fixture.databinding.ListItemMatchesBinding
import com.siifii.pl_fixture.utils.toDate
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class FixtureAdapter(val onFavouriteClickListener: OnFavouriteClickListener) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var recyclerView: RecyclerView? = null
    var matches = ArrayList<Any>()

    fun addMatches(matches: List<MatchesItem>) {
        this.matches.clear()
        var scrollToPosition = 0
        val groupedMatches: Map<String, List<MatchesItem>> = matches.groupBy { toDate(it.date!!) }
        val dates = groupedMatches.keys
        val currentDate = SimpleDateFormat("EEE, d MMM yyyy", Locale.getDefault()).format(Date(System.currentTimeMillis()))

        dates.forEach { date ->
            val dateMatches: List<MatchesItem>? = groupedMatches[date]
            dateMatches?.let {
                this.matches.add(date)
                if (date == currentDate) scrollToPosition = this.matches.size - 1
                this.matches.addAll(dateMatches)
            }
        }

        notifyDataSetChanged()

        recyclerView?.scrollToPosition(scrollToPosition)
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        this.recyclerView = recyclerView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == FixtureItems.DATES.value)
            DatesHolder(ListItemMatchesDateBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        else FixtureHolder(ListItemMatchesBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = matches.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is DatesHolder -> {
                holder.mBinding.TVDate.text = matches[holder.adapterPosition].toString()
            }

            is FixtureHolder -> {
                val match = matches[position] as MatchesItem
                holder.bind(match)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        val matches = matches[position]
        return if (matches is String) FixtureItems.DATES.value else FixtureItems.MATCHES.value
    }

    inner class FixtureHolder(private val mBinding: ListItemMatchesBinding) :
            RecyclerView.ViewHolder(mBinding.root) {
        private val viewModel = MatchItemViewModel()
        fun bind(matchesItem: MatchesItem) {
            viewModel.bind(matchesItem)
            mBinding.matchItemVM = viewModel

            mBinding.btnFavourite.setOnClickListener {
                mBinding.btnFavourite.onClick(it)
                onFavouriteClickListener.onFavouriteClicked(matchesItem)
            }
        }
    }

    inner class DatesHolder(val mBinding: ListItemMatchesDateBinding) :
            RecyclerView.ViewHolder(mBinding.root)

    enum class FixtureItems(val value: Int) {
        DATES(0), MATCHES(1)
    }

}