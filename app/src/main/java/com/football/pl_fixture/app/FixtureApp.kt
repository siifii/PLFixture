package com.football.pl_fixture.app

import android.app.Application
import com.football.pl_fixture.di.module.databaseModule
import com.football.pl_fixture.di.module.fixtureViewModel
import com.football.pl_fixture.di.module.networkModule
import org.koin.android.ext.android.startKoin

class FixtureApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(databaseModule, networkModule, fixtureViewModel))
    }
}