package com.bzahov.godofrowing.analytics.screens.goals.details

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bzahov.godofrowing.analytics.navigation.AppScreen
import com.bzahov.godofrowing.analytics.screens.goals.GoalsScreenViewModel

@Composable
fun GoalDetailsScreen(
    navController: NavController,
    viewModel: GoalsScreenViewModel = hiltViewModel()
) {
    Text(text = AppScreen.getCurrentScreenByNavController(navController).title)

}

