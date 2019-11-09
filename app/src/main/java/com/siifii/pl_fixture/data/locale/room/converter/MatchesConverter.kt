package com.siifii.pl_fixture.data.locale.room.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.siifii.pl_fixture.data.model.Score
import com.siifii.pl_fixture.data.model.Team

class MatchesConverter {

    @TypeConverter
    fun stringToScore(string: String): Score {
        return Gson().fromJson<Score>(string, Score::class.java)
    }

    @TypeConverter
    fun scoreToString(score: Score): String {
        return Gson().toJson(score)
    }

    @TypeConverter
    fun stringToTeam(string: String): Team {
        return Gson().fromJson<Team>(string, Team::class.java)
    }

    @TypeConverter
    fun teamToString(team: Team): String {
        return Gson().toJson(team)
    }
}