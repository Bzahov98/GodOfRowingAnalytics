package com.bzahov.godofrowing.analytics.data.local.dataStore

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import com.bzahov.godofrowing.analytics.data.local.UserPreference
import com.google.protobuf.InvalidProtocolBufferException
import java.io.InputStream
import java.io.OutputStream

object UserSerializer : Serializer<UserPreference> {
    override val defaultValue: UserPreference = UserPreference.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): UserPreference {
        try {
            return UserPreference.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto.", exception)
        }
    }

    override suspend fun writeTo(t: UserPreference, output: OutputStream) = t.writeTo(output)
}