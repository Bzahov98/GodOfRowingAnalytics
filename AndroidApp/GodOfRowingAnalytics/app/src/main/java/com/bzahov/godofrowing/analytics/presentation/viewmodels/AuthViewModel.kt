package com.bzahov.godofrowing.analytics.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.bzahov.godofrowing.analytics.data.repositories.AuthRepoImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authRepoImpl: AuthRepoImpl,
//    private val notifyRepoImpl: NotifyRepoImpl,
//    private val postRepoImpl: PostRepoImpl,
) : ViewModel() {

    init {
        Timber.e("Hola este es el auth view model")
    }
}
