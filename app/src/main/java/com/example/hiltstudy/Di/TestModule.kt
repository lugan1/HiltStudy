package com.example.hiltstudy.Di

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