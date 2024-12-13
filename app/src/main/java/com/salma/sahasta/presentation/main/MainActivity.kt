package com.salma.sahasta.presentation.main

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.salma.sahasta.R
import com.salma.sahasta.databinding.ActivityMainBinding
import com.salma.sahasta.presentation.ViewModelFactory
import com.salma.sahasta.presentation.login.LoginActivity

class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModels {
        ViewModelFactory.getInstance(this)
    }

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            insets
        }
        window.statusBarColor = Color.WHITE
        WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars = true

        mainViewModel.getSession().observe(this) { userModel ->
            if (!userModel.isLogin) {
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        }

        setClickListener()
        setupBottomNav()
    }

    private fun setClickListener() {
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
        if (navController.currentDestination?.id != R.id.menu_tab_nutrition) {
            navController.popBackStack(R.id.menu_tab_nutrition, false)
        }
    }
}