package com.salma.sahasta.presentation.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.salma.sahasta.databinding.FragmentHomeBinding
import com.salma.sahasta.presentation.babydata.BabyDataActivity
import com.salma.sahasta.presentation.babygrowth.BabyGrowthActivity

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setClickListener()
    }

    private fun setClickListener() {
        binding.llHomeMenu.btnBabyData.setOnClickListener {
            navigateToBabyData()
        }
        binding.llHomeMenu.btnMonitoring.setOnClickListener {
            navigateToBabyGrowth()
        }
    }

    private fun navigateToBabyData() {
        startActivity(
            Intent(requireContext(), BabyDataActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_SINGLE_TOP or Intent.FLAG_ACTIVITY_CLEAR_TOP
            },
        )
    }

    private fun navigateToBabyGrowth() {
        startActivity(
            Intent(requireContext(), BabyGrowthActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_SINGLE_TOP or Intent.FLAG_ACTIVITY_CLEAR_TOP
            }
        )
    }
}