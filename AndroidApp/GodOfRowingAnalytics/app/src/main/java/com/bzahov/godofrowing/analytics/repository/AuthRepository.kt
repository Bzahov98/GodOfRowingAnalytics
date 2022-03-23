package com.bzahov.godofrowing.analytics.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import javax.inject.Inject

class AuthRepository @Inject constructor() {

    private val auth: FirebaseAuth = Firebase.auth

}