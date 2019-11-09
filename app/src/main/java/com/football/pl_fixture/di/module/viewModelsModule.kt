package com.football.pl_fixture.di.module

import com.football.pl_fixture.ui.fixture.FixtureViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val fixtureViewModel = module {
    viewModel { FixtureViewModel(get(), get()) }
}