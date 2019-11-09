package com.football.pl_fixture.ui.fixture

import com.football.pl_fixture.data.model.MatchesItem

interface OnFavouriteClickListener {
    fun onFavouriteClicked(matchesItem: MatchesItem)
}