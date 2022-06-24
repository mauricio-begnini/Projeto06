package com.example.projeto06.data.source

import com.example.projeto06.data.domain.Hero
import com.example.projeto06.data.local.LocalHero

data class SourceHeroContainer(
    val sourceHeroes: List<SourceHero>
)

data class SourceHero (
    val id: Int,
    val img: String,
    val localized_name: String,
)

fun SourceHeroContainer.asDomainModel(): List<Hero> {
    return sourceHeroes.map{
        Hero(
            id = it.id,
            localized_name = it.localized_name,
            img = it.img
        )
    }
}

fun SourceHeroContainer.asLocalModel(): List<LocalHero> {
    return sourceHeroes.map{
        LocalHero(
            id = it.id,
            localized_name = it.localized_name,
            img = it.img
        )
    }
}