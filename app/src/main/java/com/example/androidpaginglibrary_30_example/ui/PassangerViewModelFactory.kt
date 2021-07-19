package com.example.androidpaginglibrary_30_example.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidpaginglibrary_30_example.network.api.PassangerApi

class PassangerViewModelFactory(
    private val api:PassangerApi
): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PassangerViewModel(api) as T
    }
}