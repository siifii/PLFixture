package com.siifii.pl_fixture.data.model

import com.google.gson.annotations.SerializedName

data class Area(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)