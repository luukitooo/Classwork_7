package com.example.classwork_7.presentation.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.classwork_7.common.NewCourseUtil
import com.example.classwork_7.databinding.ItemCourceNewBinding
import com.example.classwork_7.domain.model.Courses

class NewCourseAdapter: ListAdapter<Courses.NewCourse, NewCourseAdapter.NewCourseViewHolder>(NewCourseItemCallBack) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = NewCourseViewHolder(
        ItemCourceNewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: NewCourseViewHolder, position: Int) {
        holder.bind()
    }

    inner class NewCourseViewHolder(private val binding: ItemCourceNewBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val newCourse = getItem(adapterPosition)
            binding.apply {
                if (newCourse.iconType == NewCourseUtil.SETTINGS.type) {
                    ivIntroduce.setImageResource(NewCourseUtil.SETTINGS.value)
                } else {
                    ivIntroduce.setImageResource(NewCourseUtil.CARD.value)
                }
                tvIntroduce.text = newCourse.title
                tvQuestion.text = newCourse.question
                tvDuration.text = (newCourse.duration!!.toInt() / 120).toString().plus(" min")
                root.setCardBackgroundColor(Color.parseColor("#".plus(newCourse.mainColor)))
            }
        }
    }

    private object NewCourseItemCallBack: DiffUtil.ItemCallback<Courses.NewCourse>() {
        override fun areItemsTheSame(
            oldItem: Courses.NewCourse,
            newItem: Courses.NewCourse
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: Courses.NewCourse,
            newItem: Courses.NewCourse
        ): Boolean {
            return oldItem == newItem
        }
    }

}