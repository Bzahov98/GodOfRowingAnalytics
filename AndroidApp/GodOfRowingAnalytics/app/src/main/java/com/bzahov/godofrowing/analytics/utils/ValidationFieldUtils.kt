package com.bzahov.godofrowing.analytics.utils

class ValidationFieldUtils {
    companion object {
        @JvmStatic
        fun isPasswordValid(password: String) = password.trim().length >= 6

        @JvmStatic
        fun isEmailValid(email: String) = email.trim().isNotBlank()
    }
}