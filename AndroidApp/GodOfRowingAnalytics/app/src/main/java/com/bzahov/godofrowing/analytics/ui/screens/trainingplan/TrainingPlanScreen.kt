package com.bzahov.godofrowing.analytics.ui.screens.trainingplan

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bzahov.godofrowing.analytics.presentation.navigation.AppScreen.Companion.getCurrentScreenByNavController

@Composable
fun TrainingPlanScreen(
    navController: NavController,
    viewModel: TrainingPlanScreenViewModel = hiltViewModel()
) {
    Text(text = getCurrentScreenByNavController(navController).title)
}


// Rowing