package com.siifii.pl_fixture.ui.fixture

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.siifii.pl_fixture.data.locale.room.FixtureDatabase
import com.siifii.pl_fixture.data.locale.room.doa.MatchesDoa
import com.siifii.pl_fixture.data.model.FullTime
import com.siifii.pl_fixture.data.model.MatchesItem
import com.siifii.pl_fixture.data.model.Score
import com.siifii.pl_fixture.data.model.Team
import com.siifii.pl_fixture.utils.TestSchedulerRule
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class TestMatchesDatabase {

    @Rule
    @JvmField
    var testSchedulerRule = TestSchedulerRule()

    lateinit var matchesDao: MatchesDoa
    lateinit var database: FixtureDatabase

    @Before
    fun createDatabase() {
        val context = ApplicationProvider.getApplicationContext<Context>()
//         context = InstrumentationRegistry.getInstrumentation().targetContext
        database = Room.inMemoryDatabaseBuilder(context, FixtureDatabase::class.java).build()
        matchesDao = database.matchesDoa()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        database.close()
    }

    @Test
    fun test_Database_Creation() {
        assert(database.isOpen)
    }

    @Test
    fun test_Read_And_Write_Matches_DB() {

        val firstMatch = MatchesItem(
            awayteam = Team(name = "ZAMALEK"),
            homeTeam = Team(name = "AL-Ahly"),
            score = Score(fullTime = FullTime(awayTeam = 3, homeTeam = 2))
        )
        val secondMatch = MatchesItem(
            awayteam = Team(name = "Liverpool"),
            homeTeam = Team(name = "Manchester City"),
            score = Score(fullTime = FullTime(awayTeam = 5, homeTeam = 3))
        )

        val thirdMatch = MatchesItem(
            isFavourite = true,
            awayteam = Team(name = "Liverpool"),
            homeTeam = Team(name = "Manchester City"),
            score = Score(fullTime = FullTime(awayTeam = 5, homeTeam = 3))
        )

        matchesDao.insert(firstMatch)

        val insertedMatches = matchesDao.getAllMatches
        assert(insertedMatches.size == 1)
    }
}