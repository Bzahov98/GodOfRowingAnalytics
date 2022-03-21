package com.bzahov.godofrowing.analytics.screens.records.details

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bzahov.godofrowing.analytics.navigation.AppScreen.Companion.getCurrentScreenByNavController
import com.bzahov.godofrowing.analytics.screens.records.RecordsScreenViewModel

@Composable
fun RecordDetailsScreen(
    navController: NavController,
    viewModel: RecordsScreenViewModel = hiltViewModel()
) {
    Text(text = getCurrentScreenByNavController(navController).title)
}


// 