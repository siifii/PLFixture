package com.football.pl_fixture.ui.bindingadapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.like.LikeButton

@BindingAdapter("adapter")
fun setAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
    view.adapter = adapter
}

@BindingAdapter("isFavourite")
fun setFavourite(likeButton: LikeButton, isFavourite: Boolean? = false) {
    isFavourite?.let { likeButton.isLiked = it }
}
