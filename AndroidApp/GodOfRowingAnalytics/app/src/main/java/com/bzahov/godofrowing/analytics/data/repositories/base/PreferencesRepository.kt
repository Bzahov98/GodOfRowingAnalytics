package com.bzahov.godofrowing.analytics.data.repositories.base


import com.bzahov.godofrowing.analytics.data.models.auth.MyUser
import kotlinx.coroutines.flow.Flow

interface PreferencesRepository {
    fun getCurrentUser(): Flow<MyUser>
    suspend fun updateUser(myUser: MyUser)
}