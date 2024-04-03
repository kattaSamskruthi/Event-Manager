

package com.example.newsapp.modules


import dagger.Module


import android.content.Context
import androidx.room.Room
import com.example.newsapp.database.LocalDatabase
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)


class DatabaseModule {

    @Singleton
    @Provides
    fun provideLocalDatabase(@ApplicationContext context : Context) : LocalDatabase {
        return Room.databaseBuilder(context, LocalDatabase::class.java, "LocalDB").build()
    }
}


