package com.football.pl_fixture.data.services.response

import com.google.gson.annotations.SerializedName
import com.football.pl_fixture.data.model.MatchesItem

data class FixtureResponse(
	@field:SerializedName("matches") val matches: List<MatchesItem> = emptyList()
)