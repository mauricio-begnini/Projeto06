package com.example.projeto06.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.projeto06.data.domain.Hero

@Entity
data class LocalHero(
    @PrimaryKey
    val id: Int,
    val img: String,
    val localized_name: String,
)

fun List<LocalHero>.asDomainModel(): List<Hero> {
    return map{
        Hero(
            id = it.id,
            localized_name = it.localized_name,
            img = it.img
        )
    }
}
