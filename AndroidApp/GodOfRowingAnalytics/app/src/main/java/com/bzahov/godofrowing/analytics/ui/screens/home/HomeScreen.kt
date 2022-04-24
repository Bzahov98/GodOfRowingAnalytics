package com.bzahov.godofrowing.analytics.ui.screens.home

import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bzahov.godofrowing.analytics.presentation.navigation.AppScreen.Companion.getCurrentScreenByNavController

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeScreenViewModel = hiltViewModel(),
    setRightTheme: () -> Unit
) {

    Text(text = getCurrentScreenByNavController(navController).title)

    TextButton(
        onClick = { viewModel.logOut(navController) }
    ) {
        Text("Sign out")
    }


}


// Rowing