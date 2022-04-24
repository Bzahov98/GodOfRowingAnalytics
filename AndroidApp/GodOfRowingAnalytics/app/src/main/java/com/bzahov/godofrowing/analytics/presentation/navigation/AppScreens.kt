package com.bzahov.godofrowing.analytics.presentation.navigation

import androidx.annotation.DrawableRes
import androidx.navigation.NavController
import com.bzahov.godofrowing.analytics.R

sealed class AppScreen(val route: String, val title: String, @DrawableRes val icon: Int = 0) {
    object Undefined :
        AppScreen(route = "undefined", title = "GodOfRowingAnalytics", icon = R.drawable.ic_home)

    object Splash : AppScreen(route = "splash", title = "", icon = R.drawable.ic_home)
    object Home : AppScreen(route = "home", title = "Home", icon = R.drawable.ic_home)

    //    object Notes : AppScreen(route = "notes", title = "Notes", icon = R.drawable.ic_outline_note_24)
    object Search : AppScreen(route = "search", title = "Search", icon = R.drawable.ic_search)
    object Profile : AppScreen(route = "profile", title = "Profile", icon = R.drawable.ic_profile)

//    object Favourites : AppScreen(route = "favourites", title = "Favourites", icon = R.drawable.ic_star)

    object WorkoutActivity : AppScreen(route = "go", title = "Just Row", icon = R.drawable.ic_home)
    object Login : AppScreen(route = "login", title = "Login", icon = R.drawable.ic_home)
    object Register :
        AppScreen(route = "signup", title = "Create account", icon = R.drawable.ic_home)

    object Goals : AppScreen(route = "goals", title = "Register", icon = R.drawable.ic_home)
    object GoalDetails :
        AppScreen(route = "goal", title = "Goal Details", icon = R.drawable.ic_home)

    object UserRecords :
        AppScreen(route = "records", title = "My Records", icon = R.drawable.ic_profile)

    object UserRecordDetails :
        AppScreen(route = "record", title = "Record Details", icon = R.drawable.ic_profile)

    object TrainingPlan :
        AppScreen(route = "plan", title = "My Training Plan", icon = R.drawable.ic_profile)

    object MyTeam : AppScreen(route = "team", title = "My Team", icon = R.drawable.ic_profile)
    object CoachSuggestions : AppScreen(
        route = "suggestions",
        title = "My coach tips",
        icon = R.drawable.ic_outline_note_24
    )


    companion object {
        @JvmStatic
        fun getCurrentScreenByNavController(navController: NavController?): AppScreen {
            return getCurrentScreenByRoute(navController?.currentDestination?.route)
        }

        @JvmStatic
        fun getCurrentScreenByRoute(currentRoute: String?): AppScreen {
            return when (currentRoute?.substringBefore("/")) {
                Splash.route -> Splash
                Home.route -> Home
//                Notes.route -> Notes // Useless maybe
                Search.route -> Search
//                Favourites.route -> Favourites
                Profile.route -> Profile

                WorkoutActivity.route -> WorkoutActivity
                Login.route -> Login
                Register.route -> Register
                Goals.route -> Goals
                GoalDetails.route -> GoalDetails
                UserRecords.route -> UserRecords
                UserRecordDetails.route -> UserRecordDetails
                TrainingPlan.route -> TrainingPlan
                MyTeam.route -> MyTeam
                CoachSuggestions.route -> CoachSuggestions
                else -> {
                    Undefined
                }
            }
        }
    }
}