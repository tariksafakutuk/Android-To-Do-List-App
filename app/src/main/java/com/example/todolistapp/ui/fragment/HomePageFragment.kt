package com.example.todolistapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolistapp.R
import com.example.todolistapp.data.entity.Task
import com.example.todolistapp.databinding.FragmentHomePageBinding
import com.example.todolistapp.ui.adapter.TaskAdapter
import com.example.todolistapp.ui.viewmodel.HomePageViewModel
import com.example.todolistapp.utils.changePage

class HomePageFragment : Fragment() {
    private lateinit var binding: FragmentHomePageBinding
    private lateinit var viewModel: HomePageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home_page, container, false)
        binding.homePageFragment = this

        setStatusBarColor()

        binding.searchViewTask.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                search(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                search(newText)
                return true
            }
        })

        val taskList = ArrayList<Task>()
        val t1 = Task(1, "Walk with dog", "02/11/2023", "10:00", true)
        val t2 = Task(2, "Training in the Gym", "04/11/2023", "11:30", false)
        val t3 = Task(3, "Buy apple and milk", "04/11/2023", "14:00", false)
        taskList.add(t1)
        taskList.add(t2)
        taskList.add(t3)

        val adapter = TaskAdapter(requireContext(), taskList)
        binding.taskAdapter = adapter

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: HomePageViewModel by viewModels()
        viewModel = tempViewModel
    }

    private fun setStatusBarColor() {
        val background = resources.getDrawable(R.drawable.bg_layout)
        requireActivity().window.statusBarColor = ContextCompat.getColor(requireContext(), android.R.color.transparent)
        requireActivity().window.setBackgroundDrawable(background)
    }

    fun search(queryWord: String?) {
        if (queryWord != null) {
            Log.e("Message", queryWord)
        }
    }

    fun clickFab(view: View) {
        Navigation.changePage(view, R.id.action_homePageFragment_to_addTaskFragment)
    }
}