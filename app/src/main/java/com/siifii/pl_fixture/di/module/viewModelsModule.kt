package com.siifii.pl_fixture.di.module

import com.siifii.pl_fixture.ui.fixture.FixtureViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val fixtureViewModel = module {
    viewModel { FixtureViewModel(get(), get()) }
}