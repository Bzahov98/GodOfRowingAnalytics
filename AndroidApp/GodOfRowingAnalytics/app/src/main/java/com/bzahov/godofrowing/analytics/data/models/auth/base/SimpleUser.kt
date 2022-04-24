package com.bzahov.godofrowing.analytics.data.models.auth.base

abstract class SimpleUser(
    @Transient
    open var idUser: String = "",
    @Transient
    open var nameUser: String = "",
    @Transient
    open var urlImg: String = "",
)