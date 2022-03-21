package com.bzahov.godofrowing.analytics.screens.search

import androidx.lifecycle.ViewModel
import com.bzahov.godofrowing.analytics.repository.RowingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchScreenViewModel @Inject constructor(
    private val repository: RowingRepository
) : ViewModel() {

    init {

    }
}