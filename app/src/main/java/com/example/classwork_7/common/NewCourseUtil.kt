package com.example.classwork_7.common

import androidx.annotation.DrawableRes
import com.example.classwork_7.R

enum class NewCourseUtil(val type: String, @DrawableRes val value: Int) {
    SETTINGS("settings", R.drawable.ic_settings),
    CARD("card", R.drawable.ic_card)
}