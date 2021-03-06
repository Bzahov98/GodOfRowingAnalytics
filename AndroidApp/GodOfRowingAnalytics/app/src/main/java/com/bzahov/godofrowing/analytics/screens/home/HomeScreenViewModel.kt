package com.bzahov.godofrowing.analytics.screens.home

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.bzahov.godofrowing.analytics.navigation.AppScreen
import com.bzahov.godofrowing.analytics.repository.AuthRepository
import com.bzahov.godofrowing.analytics.repository.RowingRepository
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val repository: RowingRepository,
    private val authRepo: AuthRepository
) : ViewModel() {

    init {

    }


    fun logOut(navController: NavController) {
        authRepo.logOut(navController)
    }
}