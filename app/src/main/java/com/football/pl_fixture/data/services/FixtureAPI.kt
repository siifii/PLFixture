package com.football.pl_fixture.data.services

import com.football.pl_fixture.BuildConfig
import com.football.pl_fixture.data.services.response.FixtureResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Header

interface FixtureAPI {
    @GET("/v2/competitions/2021/matches")
    fun getMatches(@Header("X-Auth-Token") apiKey :String = BuildConfig.API_KEY) : Observable<FixtureResponse>

}