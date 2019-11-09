package com.football.pl_fixture.data.model

import com.google.gson.annotations.SerializedName

data class FullTime(

	@field:SerializedName("awayTeam")
	val awayTeam: Int? = 0,

	@field:SerializedName("homeTeam")
	val homeTeam: Int? = 0
)