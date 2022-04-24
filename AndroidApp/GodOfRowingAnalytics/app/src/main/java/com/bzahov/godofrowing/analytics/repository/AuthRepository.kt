package com.bzahov.godofrowing.analytics.repository

import androidx.navigation.NavController
import com.bzahov.godofrowing.analytics.navigation.AppScreen
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import javax.inject.Inject
import javax.inject.Singleton

class AuthRepository @Inject constructor() {

    @Singleton
    private val auth: FirebaseAuth = Firebase.auth

    fun logOut(navController: NavController) {
        auth.signOut()
        navController.navigate(AppScreen.Login.route)
    }

    fun getAuth() = auth

}