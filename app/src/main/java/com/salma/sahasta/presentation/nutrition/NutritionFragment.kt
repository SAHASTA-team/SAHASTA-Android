package com.salma.sahasta.presentation.nutrition

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.salma.sahasta.databinding.FragmentNutritionBinding

class NutritionFragment : Fragment() {
    private lateinit var binding: FragmentNutritionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNutritionBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}