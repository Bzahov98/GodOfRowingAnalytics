package com.bzahov.godofrowing.analytics.screens.home

import androidx.compose.material.Button
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bzahov.godofrowing.analytics.R
import com.bzahov.godofrowing.analytics.navigation.AppScreen.Companion.getCurrentScreenByNavController

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