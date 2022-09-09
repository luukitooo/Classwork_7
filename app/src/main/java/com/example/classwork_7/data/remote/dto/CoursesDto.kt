package com.example.classwork_7.data.remote.dto

import com.example.classwork_7.domain.model.Courses
import com.google.gson.annotations.SerializedName

data class CoursesDto(
    @SerializedName("new_courses")
    val newCourses: List<NewCourseDto>?,
    @SerializedName("active_courses")
    val activeCourses: List<ActiveCourseDto>?
) {
    data class NewCourseDto(
        val id: String?,
        @SerializedName("icon_type")
        val iconType: String?,
        val duration: String?,
        val title: String?,
        val question: String?,
        @SerializedName("main_color")
        val mainColor: String?
    ) {

        fun toNewCourse() = Courses.NewCourse(
            id = id,
            iconType = iconType,
            duration = duration,
            title = title,
            question = question,
            mainColor = mainColor
        )

    }

    data class ActiveCourseDto(
        val id: String?,
        @SerializedName("booking_time")
        val bookingTime: String?,
        val progress: String?,
        val title: String?,
        @SerializedName("main_color")
        val mainColor: String?,
        @SerializedName("background_color_percent")
        val backgroundColorPercent: String?,
        @SerializedName("play_button_color_percent")
        val playButtonColorPercent: String?,
        val image: String?
    ) {

        fun toActiveCourse() = Courses.ActiveCourse(
            id = id,
            bookingTime = bookingTime,
            progress = progress,
            title = title,
            mainColor = mainColor,
            backgroundColorPercent = backgroundColorPercent,
            playButtonColorPercent = playButtonColorPercent,
            image = image
        )

    }

    fun toCourses() = Courses(
        newCourses = newCourses?.map { it.toNewCourse() },
        activeCourses = activeCourses?.map { it.toActiveCourse() }
    )

}
