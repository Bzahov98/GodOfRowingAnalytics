package com.bzahov.godofrowing.analytics.screens.auth.register

import androidx.lifecycle.ViewModel
import com.bzahov.godofrowing.analytics.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterScreenViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {

    init {

    }
}