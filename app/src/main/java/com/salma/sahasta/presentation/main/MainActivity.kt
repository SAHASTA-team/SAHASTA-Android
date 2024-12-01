package com.salma.sahasta.presentation.main

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.salma.sahasta.R
import com.salma.sahasta.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
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
        setOnclickAction()
        setupBottomNav()
    }

    private fun setOnclickAction() {
        binding.icScan.setOnClickListener {
            navigateToNutrition()
        }
    }

    private fun setupBottomNav() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment
        val navController = navHostFragment.navController
        binding.navView.setupWithNavController(navController)
    }

    private fun navigateToNutrition() {
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        binding.navView.selectedItemId = R.id.menu_tab_nutrition
        navController.navigate(R.id.menu_tab_nutrition)
    }
}