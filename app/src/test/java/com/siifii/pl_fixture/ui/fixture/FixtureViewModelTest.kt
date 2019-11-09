package com.siifii.pl_fixture.ui.fixture

import androidx.arch.core.executor.ArchTaskExecutor
import androidx.arch.core.executor.TaskExecutor
import com.siifii.pl_fixture.data.locale.room.doa.MatchesDoa
import com.siifii.pl_fixture.di.testApiModule
import com.siifii.pl_fixture.utils.TestSchedulerRule
import junit.framework.Assert.assertNotNull
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.koin.standalone.StandAloneContext
import org.koin.standalone.get
import org.koin.test.KoinTest
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class FixtureViewModelTest : KoinTest {

    @Rule
    @JvmField
    var testSchedulerRule = TestSchedulerRule()

    private lateinit var viewModel: FixtureViewModel

    @Before
    @Throws(Exception::class)
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        StandAloneContext.startKoin(listOf(testApiModule))

        ArchTaskExecutor.getInstance().setDelegate(object : TaskExecutor() {
            override fun executeOnDiskIO(runnable: Runnable) = runnable.run()
            override fun isMainThread(): Boolean = true
            override fun postToMainThread(runnable: Runnable) = runnable.run()
        })

        viewModel = FixtureViewModel(get(), Mockito.mock(MatchesDoa::class.java))

    }

    @After
    fun tearDown() {
        ArchTaskExecutor.getInstance().setDelegate(null)
        StandAloneContext.stopKoin()
    }

    @Test
    fun test_ViewModel_NotNull() {
        assertNotNull(viewModel)
    }

}