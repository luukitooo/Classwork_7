package com.example.classwork_7.di

import com.example.classwork_7.data.remote.CoursesApi
import com.example.classwork_7.data.repository.CoursesRepositoryImpl
import com.example.classwork_7.domain.repository.CoursesRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://run.mocky.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideCoursesApi(retrofit: Retrofit): CoursesApi {
        return retrofit.create(CoursesApi::class.java)
    }

}

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryAppModule {

    @Binds
    @Singleton
    abstract fun bindCoursesRepository(
        coursesRepositoryImpl: CoursesRepositoryImpl
    ): CoursesRepository

}