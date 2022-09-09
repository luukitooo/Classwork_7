package com.example.classwork_7.domain.usecase

import com.example.classwork_7.domain.model.Courses
import com.example.classwork_7.domain.repository.CoursesRepository
import javax.inject.Inject

class GetCoursesUseCase @Inject constructor(
    private val repository: CoursesRepository
) {

    suspend operator fun invoke(): Courses? {
        return repository.getAllCourses()
    }

}