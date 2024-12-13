package com.salma.sahasta.presentation.addbabygrowth

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.salma.sahasta.R
import com.salma.sahasta.databinding.ActivityAddBabyGrowthBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class AddBabyGrowthActivity : AppCompatActivity() {
    private val binding: ActivityAddBabyGrowthBinding by lazy {
        ActivityAddBabyGrowthBinding.inflate(layoutInflater)
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
        binding.tiEtDateMeasurement.setOnClickListener {
            showDateMeasurementPickerDialog()
        }
    }

    private fun showDateMeasurementPickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val dateBirthPickerDialog =
            DatePickerDialog(
                this,
                { _, selectedYear, selectedMonth, selectedDay ->
                    calendar.apply {
                        set(Calendar.YEAR, selectedYear)
                        set(Calendar.MONTH, selectedMonth)
                        set(Calendar.DAY_OF_MONTH, selectedDay)
                    }
                    val formattedDate = SimpleDateFormat("yyyy-MM-dd", Locale("id", "ID")).format(calendar.time)
                    binding.tiEtDateMeasurement.setText(formattedDate)
                },
                year,
                month,
                day,
            )

        dateBirthPickerDialog.show()
    }
}