package com.example.classwork_7.data.remote

import com.example.classwork_7.data.remote.dto.CoursesDto
import com.example.classwork_7.domain.model.Courses
import retrofit2.Response
import retrofit2.http.GET

interface CoursesApi {

    @GET("v3/4167a598-b68c-420f-b6e1-fef68b89a10d")
    suspend fun getAllCourses(): Response<CoursesDto>

}