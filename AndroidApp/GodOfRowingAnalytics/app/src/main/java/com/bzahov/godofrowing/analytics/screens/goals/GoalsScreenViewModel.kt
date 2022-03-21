package com.bzahov.godofrowing.analytics.screens.goals

import androidx.lifecycle.ViewModel
import com.bzahov.godofrowing.analytics.repository.RowingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GoalsScreenViewModel @Inject constructor(
    private val repository: RowingRepository
) : ViewModel() {

    init {

    }
}