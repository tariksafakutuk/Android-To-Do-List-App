package com.example.todolistapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.todolistapp.R
import com.example.todolistapp.databinding.FragmentTaskDetailBinding
import com.example.todolistapp.ui.viewmodel.TaskDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TaskDetailFragment : Fragment() {
    private lateinit var binding: FragmentTaskDetailBinding
    private lateinit var viewModel: TaskDetailViewModel

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

        viewModel.taskDate.observe(viewLifecycleOwner) {
            binding.taskDate = it
        }

        viewModel.taskTime.observe(viewLifecycleOwner) {
            binding.taskTime = it
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: TaskDetailViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun onBackPressed() {
        requireActivity().onBackPressedDispatcher.onBackPressed()
    }

    fun selectDate() {
        viewModel.selectDate(requireActivity().supportFragmentManager)
    }

    fun selectTime() {
        viewModel.selectTime(requireActivity().supportFragmentManager)
    }

    fun updateTask(taskId: Int, taskTitle: String, taskDate: String, taskTime: String) {
        viewModel.updateTask(taskId, taskTitle, taskDate, taskTime)
        onBackPressed()
    }
}