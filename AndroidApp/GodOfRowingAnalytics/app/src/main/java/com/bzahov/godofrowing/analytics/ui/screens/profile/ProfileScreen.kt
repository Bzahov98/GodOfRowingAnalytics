package com.bzahov.godofrowing.analytics.ui.screens.profile

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bzahov.godofrowing.analytics.presentation.navigation.AppScreen.Companion.getCurrentScreenByNavController

@Composable
fun ProfileScreen(
    navController: NavController,
    viewModel: ProfileScreenViewModel = hiltViewModel()
) {
    Text(text = getCurrentScreenByNavController(navController).title)
}

