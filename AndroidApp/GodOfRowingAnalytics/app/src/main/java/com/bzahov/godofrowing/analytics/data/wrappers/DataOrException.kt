package com.bzahov.godofrowing.analytics.data.wrappers

data class DataOrException<T, Boolean, E : Exception?>(
    var data: T? = null,
    var loading: Boolean? = null,
    var e: E? = null)
