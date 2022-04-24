package com.bzahov.godofrowing.analytics.screens.auth.login

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bzahov.godofrowing.analytics.components.RowingLogoImageGallery

private const val TAG = "LoginScreen"

@Composable
fun LoginScreen(
    navController: NavController = rememberNavController(),
    viewModel: LoginScreenViewModel = hiltViewModel()
) {
    val authStatus = viewModel.authStatus //rememberSaveable { mutableStateOf(Status.IDLE) }

    LoginView()

    when (authStatus.value) {
        Status.IDLE -> {

        }
        Status.LOADING -> {
            Box(Modifier.fillMaxSize()) {
                Text(text = "LOADING")
            }
        }
        Status.SUCCESS -> {
            Box(Modifier.fillMaxSize()) {
                Text(text = "SUCCESS")
            }
//            Log.e(TAG, "authStateProgression.value ${authStateProgression.value} Status.SUCCESS")
//            navController.navigate(AppScreen.Home.route)
        }
        Status.FAILED -> {
            Box(Modifier.fillMaxSize()) {
                Text(text = "FAILED")
            }
        }
        else -> {
            Log.e(TAG, "authStatus ${authStatus.value} is unasigned")
        }
    }
}

@Preview
@Composable
private fun LoginView() {
    Surface() {
        RowingLogoImageGallery()

        Card(){

        }
    }
}