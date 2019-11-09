package com.football.pl_fixture.data.model

import com.google.gson.annotations.SerializedName

data class Team(

	@field:SerializedName("name")
	val name: String? = "",

	@field:SerializedName("id")
	val id: Int? = 0
)