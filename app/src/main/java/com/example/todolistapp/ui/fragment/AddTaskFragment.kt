package com.example.todolistapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.example.todolistapp.R
import com.example.todolistapp.databinding.FragmentAddTaskBinding

class AddTaskFragment : Fragment() {
    private lateinit var binding: FragmentAddTaskBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        requireActivity().window.statusBarColor = ContextCompat.getColor(requireContext(), R.color.white)

        binding = FragmentAddTaskBinding.inflate(inflater, container, false)

        binding.toolbarAddTask.title = "Add Task"

        binding.toolbarAddTask.setNavigationOnClickListener {
            onBackPressed()
        }

        binding.buttonAddTask.setOnClickListener {
            val taskTitle = binding.editTextTitle.text.toString()
            val taskDate = binding.editTextDate.text.toString()
            val taskTime = binding.editTextTime.text.toString()
            createTask(taskTitle, taskDate, taskTime)
        }

        return binding.root
    }

    fun onBackPressed() {
        requireActivity().onBackPressedDispatcher.onBackPressed()
    }

    fun createTask(taskTitle: String, taskDate: String, taskTime: String) {
        Log.e("Message", "$taskTitle - $taskDate - $taskTime")
    }
}