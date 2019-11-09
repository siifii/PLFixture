package com.football.pl_fixture.data

import com.football.pl_fixture.data.services.FixtureAPI
import com.football.pl_fixture.data.services.response.FixtureResponse
import io.reactivex.Observable

class MockUpFixtureAPI : FixtureAPI {
    override fun getMatches(apiKey: String): Observable<FixtureResponse> {
        return Observable.just(null)
    }

}