package com.example.projeto06.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.projeto06.data.domain.Hero

@Dao
interface HeroDao {

    @Query("SELECT * FROM localhero order by localized_name")
    fun getAllHeroes(): LiveData<List<LocalHero>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllHeroes(heroes: List<LocalHero>)

}