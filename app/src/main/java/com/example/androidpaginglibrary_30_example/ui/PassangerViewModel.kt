package com.example.androidpaginglibrary_30_example.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.androidpaginglibrary_30_example.network.api.PassangerApi
import com.example.androidpaginglibrary_30_example.network.data.repository.PassangerDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PassangerViewModel @Inject constructor(
    private val api:PassangerApi): ViewModel() {
        val passangers = Pager(PagingConfig(pageSize = 10)) {
            PassangerDataSource(api)
 }.flow.cachedIn(viewModelScope)
}