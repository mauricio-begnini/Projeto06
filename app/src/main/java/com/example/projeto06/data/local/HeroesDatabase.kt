package com.example.projeto06.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [LocalHero::class], version = 1)
abstract class HeroesDatabase : RoomDatabase() {

    abstract fun heroDao(): HeroDao

    companion object {

        @Volatile
        private var INSTANCE: HeroesDatabase? = null

        fun getInstance(context: Context): HeroesDatabase {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    HeroesDatabase::class.java,
                    "heroes_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instance
                return instance
            }
        }

    }

}