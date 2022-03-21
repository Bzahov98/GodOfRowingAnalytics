package com.bzahov.godofrowing.analytics.screens.home

import androidx.lifecycle.ViewModel
import com.bzahov.godofrowing.analytics.repository.RowingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val repository: RowingRepository
) : ViewModel() {

    init {

    }
}