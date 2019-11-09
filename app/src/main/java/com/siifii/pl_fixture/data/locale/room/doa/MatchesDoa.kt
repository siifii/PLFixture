package com.siifii.pl_fixture.data.locale.room.doa

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.siifii.pl_fixture.data.model.MatchesItem

@Dao
interface MatchesDoa {
    @get:Query("SELECT * FROM matches ORDER BY date ASC")
    val getAllMatches: List<MatchesItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg matchesItem: MatchesItem)

    @get:Query("SELECT * FROM matches WHERE isFavourite = 1 ORDER BY date ASC")
    val getFavouriteMatches: List<MatchesItem>

}