package com.example.todolistapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.navArgs
import com.example.todolistapp.R
import com.example.todolistapp.databinding.FragmentTaskDetailBinding

class TaskDetailFragment : Fragment() {
    private lateinit var binding: FragmentTaskDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        requireActivity().window.statusBarColor = ContextCompat.getColor(requireContext(), R.color.white)

        binding = FragmentTaskDetailBinding.inflate(inflater, container, false)

        binding.toolbarTaskDetail.title = "Task Detail"

        binding.toolbarTaskDetail.setNavigationOnClickListener {
            onBackPressed()
        }

        val bundle: TaskDetailFragmentArgs by navArgs()
        val task = bundle.task

        binding.editTextTitle.setText(task.taskTitle)
        binding.editTextDate.setText(task.taskDate)
        binding.editTextTime.setText(task.taskTime)

        binding.buttonUpdateTask.setOnClickListener {
            val taskTitle = binding.editTextTitle.text.toString()
            val taskDate = binding.editTextDate.text.toString()
            val taskTime = binding.editTextTime.text.toString()
            updateTask(task.taskId, taskTitle, taskDate, taskTime)
        }

        return binding.root
    }

    fun onBackPressed() {
        requireActivity().onBackPressedDispatcher.onBackPressed()
    }

    fun updateTask(taskId: Int, taskTitle: String, taskDate: String, taskTime: String) {
        Log.e("Message", "$taskId - $taskTitle - $taskDate - $taskTime")
    }
}