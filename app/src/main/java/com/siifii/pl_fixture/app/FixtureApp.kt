package com.siifii.pl_fixture.app

import android.app.Application
import com.siifii.pl_fixture.di.module.databaseModule
import com.siifii.pl_fixture.di.module.fixtureViewModel
import com.siifii.pl_fixture.di.module.networkModule
import org.koin.android.ext.android.startKoin

class FixtureApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(databaseModule, networkModule, fixtureViewModel))
    }
}