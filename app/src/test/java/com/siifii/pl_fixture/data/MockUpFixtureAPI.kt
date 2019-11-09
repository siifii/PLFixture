package com.siifii.pl_fixture.data

import com.siifii.pl_fixture.data.services.FixtureAPI
import com.siifii.pl_fixture.data.services.response.FixtureResponse
import io.reactivex.Observable

class MockUpFixtureAPI : FixtureAPI {
    override fun getMatches(apiKey: String): Observable<FixtureResponse> {
        return Observable.just(null)
    }

}