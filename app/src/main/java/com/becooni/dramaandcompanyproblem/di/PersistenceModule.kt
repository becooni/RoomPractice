package com.becooni.dramaandcompanyproblem.di

import android.content.Context
import androidx.room.Room
import com.becooni.dramaandcompanyproblem.persistence.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context) =
        Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "User.db"
        )

    @Provides
    @Singleton
    fun provideUserDao(database: AppDatabase) = database.userDao()
}