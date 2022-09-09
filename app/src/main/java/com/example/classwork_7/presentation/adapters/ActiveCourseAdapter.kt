package com.example.classwork_7.presentation.adapters

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.ColorFilter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.classwork_7.databinding.ItemCourseActiveBinding
import com.example.classwork_7.domain.model.Courses

class ActiveCourseAdapter :
    ListAdapter<Courses.ActiveCourse, ActiveCourseAdapter.ActiveCourseViewHolder>(ActiveCourseItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ActiveCourseViewHolder(
        ItemCourseActiveBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: ActiveCourseViewHolder, position: Int) {
        holder.bind()
    }

    inner class ActiveCourseViewHolder(private val binding: ItemCourseActiveBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val activeCourse = getItem(adapterPosition)
            val mainColor = "#".plus(activeCourse.mainColor)
            binding.apply {
                Glide.with(this.root).load(activeCourse.image).into(ivCourse)
                tvTitle.apply {
                    text = activeCourse.title
                    setTextColor(Color.parseColor(mainColor))
                }
                tvBooking.apply {
                    text = activeCourse.bookingTime
                    setTextColor(Color.parseColor(mainColor))
                }
                background.setBackgroundColor(Color.parseColor(mainColor))
                progressBar.setIndicatorColor(Color.parseColor(mainColor))
                ivPlay.setColorFilter(Color.parseColor(mainColor))
            }
        }
    }

    private object ActiveCourseItemCallback: DiffUtil.ItemCallback<Courses.ActiveCourse>() {
        override fun areItemsTheSame(
            oldItem: Courses.ActiveCourse,
            newItem: Courses.ActiveCourse
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: Courses.ActiveCourse,
            newItem: Courses.ActiveCourse
        ): Boolean {
            return oldItem == newItem
        }
    }

}