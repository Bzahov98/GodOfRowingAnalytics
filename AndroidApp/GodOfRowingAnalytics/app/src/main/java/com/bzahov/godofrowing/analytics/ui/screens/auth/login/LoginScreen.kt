package com.bzahov.godofrowing.analytics.ui.screens.auth.login


import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bzahov.godofrowing.analytics.ui.components.RowingLogoImageGallery

private const val TAG = "LoginScreen"

@Composable
fun LoginScreen(
    navController: NavController = rememberNavController(),
    viewModel: LoginScreenViewModel = hiltViewModel(),
) {
    val authStatus = viewModel.authStatus //rememberSaveable { mutableStateOf(Status.IDLE) }

    LoginView(viewModel)

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
private fun LoginView(viewModel: LoginScreenViewModel = hiltViewModel()) {
    Surface() {
        RowingLogoImageGallery()

        Scaffold(
            bottomBar = {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(bottom = 10.dp)
                        .fillMaxWidth()
                ) {
                    Text(text = "Don't have an account?")
                    Text(
                        text = "Sign Up.",
                        modifier = Modifier
                            .padding(start = 5.dp)
                            .clickable { /*onNavigateToSignUp()*/ },
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "Instagram")
                Spacer(modifier = Modifier.size(30.dp))
//                Input(viewModel.username, placeholder = "username") {
//                    viewModel.username = it
            }
            Spacer(modifier = Modifier.size(20.dp))
//            OutlinedTextField(viewModel.password, placeholder = "Password") {
//                viewModel.password = it
//            }
            Spacer(modifier = Modifier.size(30.dp))
            Button(onClick = { /*viewModel.submit()*/ }, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Sign In")
            }
        }

    }
}
