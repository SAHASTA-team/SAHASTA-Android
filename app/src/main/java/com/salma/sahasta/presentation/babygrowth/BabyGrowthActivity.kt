package com.salma.sahasta.presentation.babygrowth

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.salma.sahasta.R
import com.salma.sahasta.databinding.ActivityBabyGrowthBinding
import com.salma.sahasta.presentation.addbabygrowth.AddBabyGrowthActivity

class BabyGrowthActivity : AppCompatActivity() {
    private val binding: ActivityBabyGrowthBinding by lazy {
        ActivityBabyGrowthBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars = true
        setClickListener()
    }

    private fun setClickListener() {
        binding.btnBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
        binding.btnAddBabyGrowthData.setOnClickListener {
            navigateToAddBabyGrowth()
        }
    }

    private fun navigateToAddBabyGrowth() {
        startActivity(
            Intent(this, AddBabyGrowthActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_SINGLE_TOP or Intent.FLAG_ACTIVITY_CLEAR_TOP
            },
        )
    }
}