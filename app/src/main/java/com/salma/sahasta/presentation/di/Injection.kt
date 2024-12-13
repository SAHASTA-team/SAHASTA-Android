package com.salma.sahasta.presentation.di

import android.content.Context
import com.salma.sahasta.presentation.data.UserRepository
import com.salma.sahasta.presentation.data.pref.UserPreference
import com.salma.sahasta.presentation.data.pref.dataStore

object Injection {
    fun provideRepository(context: Context): UserRepository {
        val pref = UserPreference.getInstance(context.dataStore)
        return UserRepository.getInstance(pref)
    }
}