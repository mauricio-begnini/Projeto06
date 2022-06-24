package com.example.projeto06

import android.app.Application
import com.example.projeto06.data.local.HeroesDatabase
import com.example.projeto06.data.repository.HeroRepository

class DotaHeroesApplication: Application() {

    private val database: HeroesDatabase by lazy {
        HeroesDatabase.getInstance(this)
    }

    val repository: HeroRepository by lazy {
        HeroRepository(database.heroDao())
    }

}