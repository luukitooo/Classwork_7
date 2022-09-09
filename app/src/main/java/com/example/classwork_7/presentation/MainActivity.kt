package com.example.classwork_7.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.example.classwork_7.common.Resource
import com.example.classwork_7.databinding.ActivityMainBinding
import com.example.classwork_7.domain.model.Courses
import com.example.classwork_7.presentation.adapters.ActiveCourseAdapter
import com.example.classwork_7.presentation.adapters.NewCourseAdapter
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel by viewModels<MainViewModel>()

    private val newCourseAdapter = NewCourseAdapter()
    private val activeCourseAdapter = ActiveCourseAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()

        observers()

    }

    private fun init(): Unit = with(binding) {
        rvNewCourses.adapter = newCourseAdapter
        rvActiveCourses.adapter = activeCourseAdapter
        lifecycleScope.launch {
            viewModel.getAllCourses()
        }
    }

    private fun observers() {
        lifecycleScope.launch {
            viewModel.coursesFlow.collect { resource ->
                handleResource(resource)
            }
        }
    }

    private fun handleResource(resource: Resource<Courses>) {
        when(resource) {
            is Resource.Success -> {
                newCourseAdapter.submitList(resource.result.newCourses)
                activeCourseAdapter.submitList(resource.result.activeCourses)
            }
            is Resource.Error -> {
                Snackbar.make(binding.root, resource.errorMessage, Snackbar.LENGTH_LONG).show()
            }
            is Resource.Loader -> {
                binding.progressBar.isVisible = resource.isLoading
            }
        }
    }

}