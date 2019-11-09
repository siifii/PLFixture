package com.siifii.pl_fixture.di

import com.siifii.pl_fixture.data.MockUpFixtureAPI
import com.siifii.pl_fixture.data.services.FixtureAPI
import org.koin.dsl.module.module

val testApiModule = module {
    single { MockUpFixtureAPI() as FixtureAPI }
}