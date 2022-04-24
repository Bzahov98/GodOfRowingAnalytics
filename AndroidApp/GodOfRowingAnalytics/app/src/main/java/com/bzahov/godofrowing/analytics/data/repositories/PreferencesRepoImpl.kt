package com.bzahov.godofrowing.analytics.data.repositories

import com.bzahov.godofrowing.analytics.data.local.PreferencesDataSource
import com.bzahov.godofrowing.analytics.data.models.auth.MyUser
import com.bzahov.godofrowing.analytics.data.repositories.base.PreferencesRepository
import kotlinx.coroutines.flow.Flow

class PreferencesRepoImpl(
    private val preferencesDataSource: PreferencesDataSource,
) : PreferencesRepository {

    override fun getCurrentUser(): Flow<MyUser> =
        preferencesDataSource.getUserFromProtoStore()

    override suspend fun updateUser(myUser: MyUser) =
        preferencesDataSource.saveUser(myUser)

}