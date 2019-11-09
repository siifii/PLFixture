package com.siifii.pl_fixture.di.module

import com.siifii.pl_fixture.data.services.FixtureAPI
import com.siifii.pl_fixture.di.provider.NetworkProvider
import org.koin.dsl.module.module
import retrofit2.Retrofit

val networkModule = module {
    single { NetworkProvider.provideRetrofitInterface() }
    single { get<Retrofit>().create(FixtureAPI::class.java) }
}