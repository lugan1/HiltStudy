package com.example.hiltstudy.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class TestModule {

    @Singleton
    @Provides
    fun provideTestDependency() : TestDependency {
        return TestDependency()
    }
}