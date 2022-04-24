package com.bzahov.godofrowing.analytics.data.repositories

import androidx.navigation.NavController
import com.bzahov.godofrowing.analytics.core.utils.InternetCheck
import com.bzahov.godofrowing.analytics.core.utils.NetworkException
import com.bzahov.godofrowing.analytics.data.local.PreferencesDataSource
import com.bzahov.godofrowing.analytics.data.models.auth.MyUser
import com.bzahov.godofrowing.analytics.data.network.dataStore.AuthDataSource
import com.bzahov.godofrowing.analytics.data.network.dataStore.ImagesDataSource
import com.bzahov.godofrowing.analytics.data.network.exceptions.ImgProfileInvalid
import com.bzahov.godofrowing.analytics.data.repositories.base.AuthRepository
import com.bzahov.godofrowing.analytics.presentation.navigation.AppScreen
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

class AuthRepoImpl @Inject constructor(
    private val authDataSource: AuthDataSource,
    private val prefDataSource: PreferencesDataSource,
    private val imagesDataSource: ImagesDataSource,
) : AuthRepository {

    override val myUser: Flow<MyUser> = prefDataSource.getUserFromProtoStore()

    override suspend fun authWithCredential(authCredential: AuthCredential) {
        val user = authDataSource.authWithCredential(authCredential)
        prefDataSource.saveUser(user)
    }

    override suspend fun uploadDataUser(urlImg: String, name: String) {
        if (!InternetCheck.isNetworkAvailable()) throw NetworkException()
        val newUrlImg = urlImg.let {
            if (imagesDataSource.invalidPhotoUser()) throw ImgProfileInvalid()
            imagesDataSource.getImageUser()
        }?.toString()
        val updateUser = authDataSource.updateDataUser(name, newUrlImg)
        prefDataSource.saveUser(updateUser)
    }

    override suspend fun logOut() {
        authDataSource.logOut()
        deleterUser()
    }

    // old
    @Singleton
    private val auth: FirebaseAuth = Firebase.auth

    fun logOut(navController: NavController) {
        auth.signOut()
        navController.navigate(AppScreen.Login.route)
    }

    // old
    fun getAuth() = auth

    override suspend fun updateTokenUser(token: String) {
        authDataSource.updateTokenUser(token)
    }

    override suspend fun deleterUser() {
        authDataSource.deleterUser()
        prefDataSource.deleterUser()
    }
}