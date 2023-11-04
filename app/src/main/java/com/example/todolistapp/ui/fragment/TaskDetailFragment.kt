package com.example.todolistapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.example.todolistapp.R
import com.example.todolistapp.databinding.FragmentTaskDetailBinding
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import java.text.SimpleDateFormat
import java.util.Locale

class TaskDetailFragment : Fragment() {
    private lateinit var binding: FragmentTaskDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        requireActivity().window.statusBarColor = ContextCompat.getColor(requireContext(), R.color.white)

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_task_detail, container, false)
        binding.taskDetailFragment = this
        binding.taskDetailToolbarTitle = "Task Detail"

        val bundle: TaskDetailFragmentArgs by navArgs()
        val task = bundle.task

        binding.taskObject = task
        binding.taskDate = task.taskDate
        binding.taskTime = task.taskTime

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

    fun updateTask(taskId: Int, taskTitle: String, taskDate: String, taskTime: String) {
        Log.e("Message", "$taskId - $taskTitle - $taskDate - $taskTime")
    }
}