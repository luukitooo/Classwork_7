package com.example.classwork_7.data.repository

import com.example.classwork_7.data.remote.CoursesApi
import com.example.classwork_7.domain.model.Courses
import com.example.classwork_7.domain.repository.CoursesRepository
import javax.inject.Inject

class CoursesRepositoryImpl @Inject constructor(
    private val api: CoursesApi
) : CoursesRepository {

    override suspend fun getAllCourses(): Courses? {
        val response = api.getAllCourses()
        if (response.isSuccessful && response.body() != null) {
            return response.body()!!.toCourses()
        }
        return null
    }

}