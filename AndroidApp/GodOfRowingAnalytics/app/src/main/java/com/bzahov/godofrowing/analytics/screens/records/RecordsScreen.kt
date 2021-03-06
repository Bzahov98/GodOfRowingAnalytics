package com.bzahov.godofrowing.analytics.screens.records

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bzahov.godofrowing.analytics.navigation.AppScreen.Companion.getCurrentScreenByNavController

@Composable
fun RecordsScreen(
    navController: NavController,
    viewModel: RecordsScreenViewModel = hiltViewModel()
) {
    Text(text = getCurrentScreenByNavController(navController).title)
}


