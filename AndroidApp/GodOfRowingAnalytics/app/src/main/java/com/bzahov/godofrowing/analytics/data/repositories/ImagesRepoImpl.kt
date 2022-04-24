package com.bzahov.godofrowing.analytics.data.repositories

import android.net.Uri
import com.bzahov.godofrowing.analytics.core.states.StorageUploadTaskResult
import com.bzahov.godofrowing.analytics.data.network.dataStore.ImagesDataSource
import com.bzahov.godofrowing.analytics.data.repositories.base.ImagesRepository
import kotlinx.coroutines.flow.Flow

class ImagesRepoImpl(
    private val imagesDataSource: ImagesDataSource,
) : ImagesRepository {
    override fun uploadImgProfile(uri: Uri): Flow<StorageUploadTaskResult> =
        imagesDataSource.uploadImageUser(uri)

//    override fun uploadImgBlog(uri: Uri, name: String): Flow<StorageUploadTaskResult> =
//        imagesDataSource.uploadImagePost(uri, name)
}