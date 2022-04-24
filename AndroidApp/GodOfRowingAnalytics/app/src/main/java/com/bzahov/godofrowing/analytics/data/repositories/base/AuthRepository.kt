package com.bzahov.godofrowing.analytics.data.repositories.base

import com.bzahov.godofrowing.analytics.data.models.auth.MyUser
import com.google.firebase.auth.AuthCredential
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    val myUser: Flow<MyUser>
    suspend fun authWithCredential(authCredential: AuthCredential)
    suspend fun updateTokenUser(token:String)
    suspend fun deleterUser()
    suspend fun uploadDataUser(urlImg: String, name: String)
    suspend fun logOut()
}