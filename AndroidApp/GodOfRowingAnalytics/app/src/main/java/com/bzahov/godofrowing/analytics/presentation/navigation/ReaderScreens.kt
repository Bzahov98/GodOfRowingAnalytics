package com.bzahov.godofrowing.analytics.presentation.navigation
//
//@Deprecated("")
//enum class RowingScreens {
//    SPLASH_SCREEN,
//    LOGIN_SCREEN,
//    REGISTRATION_SCREEN,
//    CREATE_ACCOUNT_SCREEN,
//    HOME_SCREEN,
//    WORKOUT_SEARCH_SCREEN,
//    DETAILS_SCREEN,
//    WORKOUT_ACTIVITY_SCREEN,
//    GOALS_SCREEN,
//    PROFILE_SCREEN,
//    RECORDS_SCREEN,
//    TEAM_SCREEN,
//    TRAINING_STATS_SCREEN;
//
//    companion object {
//        fun fromRoute(route: String?): RowingScreens = when (route?.substringBefore("/")) {
//            SPLASH_SCREEN.name -> SPLASH_SCREEN
//            LOGIN_SCREEN.name -> LOGIN_SCREEN
//            REGISTRATION_SCREEN.name -> REGISTRATION_SCREEN
//            CREATE_ACCOUNT_SCREEN.name -> CREATE_ACCOUNT_SCREEN
//            HOME_SCREEN.name -> HOME_SCREEN
//            WORKOUT_SEARCH_SCREEN.name -> WORKOUT_SEARCH_SCREEN
//            DETAILS_SCREEN.name -> DETAILS_SCREEN
//            GOALS_SCREEN.name -> GOALS_SCREEN
//            WORKOUT_ACTIVITY_SCREEN.name -> WORKOUT_ACTIVITY_SCREEN
//            PROFILE_SCREEN.name -> PROFILE_SCREEN
//            RECORDS_SCREEN.name -> RECORDS_SCREEN
//            TEAM_SCREEN.name -> TEAM_SCREEN
//            TRAINING_STATS_SCREEN.name -> TRAINING_STATS_SCREEN
//            null -> HOME_SCREEN
//            else -> throw IllegalArgumentException("Route $route is not recognized")
//        }
//    }
//
//
//}