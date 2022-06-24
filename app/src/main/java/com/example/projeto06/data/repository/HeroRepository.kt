package com.example.projeto06.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.projeto06.data.domain.Hero
import com.example.projeto06.data.local.HeroDao
import com.example.projeto06.data.local.asDomainModel
import com.example.projeto06.data.source.OpenDotaApi
import com.example.projeto06.data.source.SourceHeroContainer
import com.example.projeto06.data.source.asLocalModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HeroRepository(private val heroDao: HeroDao) {

    val heroes: LiveData<List<Hero>> = Transformations.map(
        heroDao.getAllHeroes()
    ){
        it.asDomainModel()
    }

    suspend fun refreshHeroes(){
        withContext(Dispatchers.IO){
            val heroes = OpenDotaApi.retrofitService.getHeroes()
            val heroesContainer = SourceHeroContainer(heroes)
            heroDao.insertAllHeroes(heroesContainer.asLocalModel())
        }
    }

}