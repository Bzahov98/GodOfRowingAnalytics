package com.bzahov.godofrowing.analytics.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.bzahov.godofrowing.analytics.data.repositories.AuthRepoImpl
import com.bzahov.godofrowing.analytics.data.repositories.RowingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val repository: RowingRepository,
    private val authRepo: AuthRepoImpl
) : ViewModel() {

    init {

    }


    fun logOut(navController: NavController) {
        authRepo.logOut(navController)
    }
}