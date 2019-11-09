package com.football.pl_fixture.di

import com.football.pl_fixture.data.MockUpFixtureAPI
import com.football.pl_fixture.data.services.FixtureAPI
import org.koin.dsl.module.module

val testApiModule = module {
    single { MockUpFixtureAPI() as FixtureAPI }
}