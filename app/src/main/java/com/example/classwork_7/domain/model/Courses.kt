package com.example.classwork_7.domain.model

data class Courses(
    val newCourses: List<NewCourse>?,
    val activeCourses: List<ActiveCourse>?
) {
    data class NewCourse(
        val id: String?,
        val iconType: String?,
        val duration: String?,
        val title: String?,
        val question: String?,
        val mainColor: String?
    )
    data class ActiveCourse(
        val id: String?,
        val bookingTime: String?,
        val progress: String?,
        val title: String?,
        val mainColor: String?,
        val backgroundColorPercent: String?,
        val playButtonColorPercent: String?,
        val image: String?
    )
}