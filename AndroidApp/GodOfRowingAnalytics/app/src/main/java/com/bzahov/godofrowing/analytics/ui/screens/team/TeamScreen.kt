
package com.bzahov.godofrowing.analytics.ui.screens.team

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bzahov.godofrowing.analytics.presentation.navigation.AppScreen.Companion.getCurrentScreenByNavController

@Composable
fun TeamScreen(
    navController: NavController,
    viewModel: () -> Unit = hiltViewModel()
) {
    Text(text = getCurrentScreenByNavController(navController).title)
}


// Rowing