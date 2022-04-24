package com.bzahov.godofrowing.analytics.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bzahov.godofrowing.analytics.screens.activity.WorkoutActivityScreen
import com.bzahov.godofrowing.analytics.screens.auth.login.LoginScreen
import com.bzahov.godofrowing.analytics.screens.auth.register.RegisterScreen
import com.bzahov.godofrowing.analytics.screens.goals.GoalsScreen
import com.bzahov.godofrowing.analytics.screens.goals.details.GoalDetailsScreen
import com.bzahov.godofrowing.analytics.screens.home.HomeScreen
import com.bzahov.godofrowing.analytics.screens.home.HomeScreenViewModel
import com.bzahov.godofrowing.analytics.screens.profile.ProfileScreen
import com.bzahov.godofrowing.analytics.screens.records.RecordsScreen
import com.bzahov.godofrowing.analytics.screens.records.details.RecordDetailsScreen
import com.bzahov.godofrowing.analytics.screens.search.SearchScreen
import com.bzahov.godofrowing.analytics.screens.splash.RowingSplashScreen
import com.bzahov.godofrowing.analytics.screens.suggestions.CoachSuggestionsScreen
import com.bzahov.godofrowing.analytics.screens.team.TeamScreen
import com.bzahov.godofrowing.analytics.screens.trainingplan.TrainingPlanScreen

@Composable
fun RowingNavigation(toggleTheme: () -> Unit) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AppScreen.Splash.route
    ) {

        composable(AppScreen.Splash.route) {
            RowingSplashScreen(navController = navController)
        }
        composable(AppScreen.Home.route) {
            val homeViewModel = hiltViewModel<HomeScreenViewModel>()
            HomeScreen(navController = navController, viewModel = homeViewModel,toggleTheme)
        }

        composable(AppScreen.Search.route) {
            SearchScreen(navController = navController)
        }

        composable(AppScreen.Profile.route) {
            ProfileScreen(navController = navController)
        }

//            composable(AppScreen.Favourites.route) {
//                FavouritesScreen(navController = navController)
//            }

        composable(AppScreen.WorkoutActivity.route) {
            WorkoutActivityScreen(navController = navController)
        }
        composable(AppScreen.Login.route) {
            LoginScreen(navController = navController)
        }
        composable(AppScreen.Register.route) {
            RegisterScreen(navController = navController)
        }
        composable(AppScreen.Goals.route) {
            GoalsScreen(navController = navController)
        }
        composable(AppScreen.GoalDetails.route) {
            GoalDetailsScreen(navController = navController)
        }
        composable(AppScreen.UserRecords.route) {
            RecordsScreen(navController = navController)
        }
        composable(AppScreen.UserRecordDetails.route) {
            RecordDetailsScreen(navController = navController)
        }
        composable(AppScreen.TrainingPlan.route) {
            TrainingPlanScreen(navController = navController)
        }
        composable(AppScreen.MyTeam.route) {
            TeamScreen(navController = navController)
        }
        composable(AppScreen.CoachSuggestions.route) {
            CoachSuggestionsScreen(navController = navController)
        }

//            composable(RowingScreens.ReaderStatsScreen.name) {
//                val homeViewModel = hiltViewModel<HomeScreenViewModel>()
//                ReaderStatsScreen(navController = navController, viewModel = homeViewModel)
//            }
//
//            composable(RowingScreens.HOME_SCREEN.name) {
//                val homeViewModel = hiltViewModel<HomeScreenViewModel>()
//                HOME_SCREEN(navController = navController, viewModel = homeViewModel)
//            }
//
//            composable(RowingScreens.WORKOUT_SEARCH_SCREEN.name) {
//                val searchViewModel = hiltViewModel<BooksSearchViewModel>()
//

    }
}