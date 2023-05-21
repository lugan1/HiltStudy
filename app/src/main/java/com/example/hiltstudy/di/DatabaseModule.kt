package com.example.hiltstudy.di

import android.content.Context
import com.example.hiltstudy.room.LocalDatabase
import com.example.hiltstudy.room.dao.LibraryDao
import com.example.hiltstudy.room.dao.UserAndLibraryDao
import com.example.hiltstudy.room.dao.UserDao
import dagger.Module
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
    fun provideDatabase(@ApplicationContext context: Context): LocalDatabase {
        return LocalDatabase.getDatabase(context)
    }

    @Provides
    fun provideUserDao(database: LocalDatabase): UserDao {
        return database.userDao()
    }

    @Provides
    fun provideLibraryDao(database: LocalDatabase): LibraryDao {
        return database.libraryDao()
    }

    @Provides
    fun provideUserAndLibraryDao(database: LocalDatabase): UserAndLibraryDao {
        return database.userAndLibraryDao()
    }
}