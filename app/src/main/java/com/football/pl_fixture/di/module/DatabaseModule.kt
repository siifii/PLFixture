package com.football.pl_fixture.di.module

import com.football.pl_fixture.data.locale.room.FixtureDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.module

val databaseModule = module {
    single { FixtureDatabase.getInstance(androidApplication()) }
    single(createOnStart = false) { get<FixtureDatabase>().matchesDoa() }
}