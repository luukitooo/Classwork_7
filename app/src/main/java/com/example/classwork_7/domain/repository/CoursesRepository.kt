package com.example.classwork_7.domain.repository

import com.example.classwork_7.domain.model.Courses

interface CoursesRepository {

    suspend fun getAllCourses(): Courses?

}