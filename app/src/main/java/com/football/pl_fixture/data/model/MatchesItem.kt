package com.football.pl_fixture.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.football.pl_fixture.data.locale.room.converter.MatchesConverter

@Entity(tableName = "matches")
@TypeConverters(MatchesConverter::class)
data class MatchesItem(

    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,

    @field:SerializedName("lastUpdated")
    val lastUpdated: String? = null,

    val isDate: Boolean = false,

    @field:SerializedName("score")
    val score: Score? = Score(),

    @field:SerializedName("stage")
    val stage: String? = "",

    @field:SerializedName("matchday")
    val matchday: Int? = 0,

    @field:SerializedName("awayTeam")
    val awayteam: Team = Team(),

    @field:SerializedName("homeTeam")
    val homeTeam: Team = Team(),

    @field:SerializedName("utcDate")
    val date: String? = "",

    @field:SerializedName("status")
    val status: String? = "",

    @field:SerializedName("group")
    val group: String? = "",

    var isFavourite: Boolean = false
) {
    companion object {
        val dateComparator: Comparator<MatchesItem> =
            Comparator { match, to -> match.date!!.compareTo(to.date!!) }
    }
}