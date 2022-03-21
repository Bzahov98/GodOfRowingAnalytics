package com.bzahov.godofrowing.analytics.screens.search

import androidx.compose.material.Text
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bzahov.godofrowing.analytics.navigation.AppScreen.Companion.getCurrentScreenByNavController
import com.bzahov.godofrowing.analytics.navigation.AppScreen.Companion.getCurrentScreenByRoute

@Composable
fun SearchScreen(
    navController: NavController,
    viewModel: SearchScreenViewModel = hiltViewModel()
) {
    Text(text = getCurrentScreenByNavController(navController).title)
}

// Rowing