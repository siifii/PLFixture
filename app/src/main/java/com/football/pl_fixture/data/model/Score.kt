package com.football.pl_fixture.data.model

import com.google.gson.annotations.SerializedName

data class Score(

    @field:SerializedName("duration")
    val duration: String? = "",

    @field:SerializedName("winner")
    val winner: String? = "",

    @field:SerializedName("fullTime")
    val fullTime: FullTime? = FullTime()
    )