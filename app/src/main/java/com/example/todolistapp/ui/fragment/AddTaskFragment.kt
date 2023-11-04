package com.example.todolistapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.todolistapp.R
import com.example.todolistapp.databinding.FragmentAddTaskBinding
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import java.text.SimpleDateFormat
import java.util.Locale

class AddTaskFragment : Fragment() {
    private lateinit var binding: FragmentAddTaskBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        requireActivity().window.statusBarColor = ContextCompat.getColor(requireContext(), R.color.white)

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_task, container, false)
        binding.addTaskFragment = this
        binding.addTaskToolbarTitle = "Add Task"

        return binding.root
    }

    fun onBackPressed() {
        requireActivity().onBackPressedDispatcher.onBackPressed()
    }

    fun selectDate() {
        val datePicker = MaterialDatePicker.Builder.datePicker()
            .setTitleText("Select Date")
            .build()

        datePicker.show(requireActivity().supportFragmentManager, "Date")

        datePicker.addOnPositiveButtonClickListener {
            val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
            binding.taskDate = dateFormat.format(it)
        }
    }

    fun selectTime() {
        val timePicker = MaterialTimePicker.Builder()
            .setTitleText("Select Time")
            .setTimeFormat(TimeFormat.CLOCK_24H)
            .build()

        timePicker.show(requireActivity().supportFragmentManager, "Time")

        timePicker.addOnPositiveButtonClickListener {
            binding.taskTime = "${timePicker.hour}:${timePicker.minute}"
        }
    }

    fun createTask(taskTitle: String, taskDate: String, taskTime: String) {
        Log.e("Message", "$taskTitle - $taskDate - $taskTime")
    }
}