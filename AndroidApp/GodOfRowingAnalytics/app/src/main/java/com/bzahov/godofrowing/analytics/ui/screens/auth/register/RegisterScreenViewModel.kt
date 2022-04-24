package com.bzahov.godofrowing.analytics.ui.screens.auth.register

import androidx.lifecycle.ViewModel
import com.bzahov.godofrowing.analytics.data.repositories.AuthRepoImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterScreenViewModel @Inject constructor(
    private val repository: AuthRepoImpl
) : ViewModel() {

    init {

    }
}