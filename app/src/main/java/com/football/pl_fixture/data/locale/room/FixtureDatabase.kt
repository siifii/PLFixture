package com.football.pl_fixture.data.locale.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.football.pl_fixture.data.locale.room.doa.MatchesDoa
import com.football.pl_fixture.data.model.MatchesItem
import com.football.pl_fixture.utils.Constants.DB_NAME
import com.football.pl_fixture.utils.Constants.DB_VERSION

@Database(entities = [MatchesItem::class], version = DB_VERSION , exportSchema = false)
abstract class FixtureDatabase : RoomDatabase() {
    abstract fun matchesDoa(): MatchesDoa

    companion object {
        @Volatile
        var INSTANCE: FixtureDatabase? = null

        fun getInstance(context: Context): FixtureDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: build(context).also { INSTANCE = it }
            }

        private fun build(context: Context) =
            Room.databaseBuilder(context.applicationContext, FixtureDatabase::class.java, DB_NAME)
                .addMigrations(MIGRATION_1_TO_2)
                .build()

        private val MIGRATION_1_TO_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {

            }
        }
    }


}