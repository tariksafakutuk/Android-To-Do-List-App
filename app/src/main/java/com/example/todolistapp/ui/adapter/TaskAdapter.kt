package com.example.todolistapp.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.todolistapp.R
import com.example.todolistapp.data.entity.Task
import com.example.todolistapp.databinding.TaskCardBinding
import com.example.todolistapp.ui.fragment.HomePageFragmentDirections
import com.example.todolistapp.utils.changePage

class TaskAdapter(private var mContext: Context, private var taskList: List<Task>) :
    RecyclerView.Adapter<TaskAdapter.TaskHolder>() {

    inner class TaskHolder(var design: TaskCardBinding) :
        RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskHolder {
        val binding = TaskCardBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return TaskHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskHolder, position: Int) {
        val task = taskList.get(position)
        val binding = holder.design

        binding.tvTaskTitle.text = task.taskTitle
        binding.tvTaskDate.text = task.taskDate
        binding.tvTaskTime.text = task.taskTime

        if (task.taskActivated) {
            binding.tvTaskTitle.setTextColor(ContextCompat.getColor(mContext, R.color.white))
            binding.tvTaskDate.setTextColor(ContextCompat.getColor(mContext, R.color.white))
            binding.tvTaskTime.setTextColor(ContextCompat.getColor(mContext, R.color.white))

            binding.cardViewTask.setCardBackgroundColor(ContextCompat.getColor(mContext, R.color.bg_button))
            binding.ivTaskTitle.setColorFilter(ContextCompat.getColor(mContext, R.color.white))
            binding.ivTaskDate.setColorFilter(ContextCompat.getColor(mContext, R.color.white))
            binding.ivTaskTime.setColorFilter(ContextCompat.getColor(mContext, R.color.white))
            binding.ivRightButton.setColorFilter(ContextCompat.getColor(mContext, R.color.white))

            binding.cbTask.isChecked = true
        } else {
            binding.tvTaskTitle.setTextColor(ContextCompat.getColor(mContext, R.color.black))
            binding.tvTaskDate.setTextColor(ContextCompat.getColor(mContext, R.color.black))
            binding.tvTaskTime.setTextColor(ContextCompat.getColor(mContext, R.color.black))

            binding.cardViewTask.setBackgroundResource(R.drawable.bg_layout)
            binding.ivTaskTitle.setColorFilter(ContextCompat.getColor(mContext, R.color.bg_button))
            binding.ivTaskDate.setColorFilter(ContextCompat.getColor(mContext, R.color.bg_button))
            binding.ivTaskTime.setColorFilter(ContextCompat.getColor(mContext, R.color.bg_button))
            binding.ivRightButton.setColorFilter(ContextCompat.getColor(mContext, R.color.bg_button))

            binding.cbTask.isChecked = false
        }

        binding.cbTask.setOnClickListener {
            Log.e("Message", "Task Activated")
        }

        binding.cardViewTask.setOnClickListener {
            val direction = HomePageFragmentDirections.actionHomePageFragmentToTaskDetailFragment(task = task)
            Navigation.changePage(it, direction)
        }
    }

    override fun getItemCount(): Int {
        return taskList.size
    }
}