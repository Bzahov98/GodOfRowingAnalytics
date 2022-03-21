package com.bzahov.godofrowing.analytics.screens.auth.login

import androidx.lifecycle.ViewModel
import com.bzahov.godofrowing.analytics.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginScreenViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {

    init {

    }
}