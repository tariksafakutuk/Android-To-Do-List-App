package com.example.todolistapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.todolistapp.R
import com.example.todolistapp.databinding.FragmentSplashScreenBinding
import com.example.todolistapp.utils.changePage

class SplashScreenFragment : Fragment() {
    private lateinit var binding: FragmentSplashScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashScreenBinding.inflate(inflater, container, false)

        binding.buttonSplashScreen.setOnClickListener {
            clickButton(it)
        }

        return binding.root
    }

    fun clickButton(view: View) {
        Navigation.changePage(view, R.id.action_splashScreenFragment_to_homePageFragment)
    }
}