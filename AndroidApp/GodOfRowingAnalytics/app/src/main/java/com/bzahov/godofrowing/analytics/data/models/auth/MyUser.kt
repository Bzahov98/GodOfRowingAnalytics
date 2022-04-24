package com.bzahov.godofrowing.analytics.data.models.auth

import com.bzahov.godofrowing.analytics.data.models.auth.base.SimpleUser
import com.google.firebase.firestore.Exclude
import com.google.firebase.firestore.ServerTimestamp
import java.util.*

data class MyUser(
    @set:Exclude @get:Exclude
    override var idUser: String = "",
    override var nameUser: String = "",
    override var urlImg: String = "",
    var emailUser:String="",
    var token: String = "",
    @ServerTimestamp
    var timeCreate: Date? = null,
    @ServerTimestamp
    var timeUpdate: Date? = null,
) : SimpleUser()