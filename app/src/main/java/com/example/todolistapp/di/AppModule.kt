package com.example.todolistapp.di

import com.example.todolistapp.data.datasource.TaskDataSource
import com.example.todolistapp.data.repo.TaskRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideTaskDataSource(): TaskDataSource {
        return TaskDataSource()
    }

    @Provides
    @Singleton
    fun provideTaskRepository(tds: TaskDataSource): TaskRepository {
        return TaskRepository(tds)
    }
}