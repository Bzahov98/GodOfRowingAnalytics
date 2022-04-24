package com.bzahov.godofrowing.analytics.data.repositories.base

import android.net.Uri
import com.bzahov.godofrowing.analytics.core.states.StorageUploadTaskResult
import kotlinx.coroutines.flow.Flow

interface ImagesRepository {
    fun uploadImgProfile(uri: Uri): Flow<StorageUploadTaskResult>
//    fun uploadImgBlog(uri: Uri, name: String): Flow<StorageUploadTaskResult>
}