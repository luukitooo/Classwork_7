package com.example.classwork_7.presentation

import androidx.lifecycle.ViewModel
import com.example.classwork_7.common.Resource
import com.example.classwork_7.domain.model.Courses
import com.example.classwork_7.domain.repository.CoursesRepository
import com.example.classwork_7.domain.usecase.GetCoursesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getCoursesUseCase: GetCoursesUseCase
) : ViewModel() {

    private val _coursesFlow = MutableSharedFlow<Resource<Courses>>()
    val coursesFlow get() = _coursesFlow.asSharedFlow()

    suspend fun getAllCourses() {
        _coursesFlow.emit(Resource.Loader(isLoading = true))
        val courses = getCoursesUseCase()
        if (courses != null) {
            _coursesFlow.emit(Resource.Success(courses))
        } else {
            _coursesFlow.emit(Resource.Error("Can't get data..."))
        }
        _coursesFlow.emit(Resource.Loader(isLoading = false))
    }

}