package com.example.newsapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ic.newsapp.Article

@Database(entities = [Article::class], version = 1)
abstract class LocalDatabase : RoomDatabase() {

    abstract fun getLocalDao(): LocalDao
}

