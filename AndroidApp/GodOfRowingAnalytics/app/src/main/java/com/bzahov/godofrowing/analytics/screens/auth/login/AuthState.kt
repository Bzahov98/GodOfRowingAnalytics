package com.bzahov.godofrowing.analytics.screens.auth.login

enum class AuthState(var status: Status = Status.IDLE, val message: String? = null) {

    Logging(),
    SigningUp(),
    ForgotPassword(),
}
//    companion object {
//        val Logging = LoadingState(LoadingState.Status.IDLE)
//        val SigningUp = LoadingState(LoadingState.Status.IDLE)
//        val ForgotPassword = LoadingState(LoadingState.Status.IDLE)
//        val FAILED = LoadingState(LoadingState.Status.IDLE)
//    }


enum class Status {

    SUCCESS,
    FAILED,
    LOADING,
    IDLE

}

