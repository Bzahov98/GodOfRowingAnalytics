package com.bzahov.godofrowing.analytics.general

import android.app.Application
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.firestoreSettings
import com.google.firebase.ktx.Firebase
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.FormatStrategy
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class RowAnalyticsApplication : Application() {
//    override fun onCreate() {
//        super.onCreate()
//
//        val settings = firestoreSettings {
//            isPersistenceEnabled = false
//        }
//        Firebase.firestore.firestoreSettings = settings
//
//        val formatStrategy: FormatStrategy = PrettyFormatStrategy.newBuilder()
//            .showThreadInfo(true) // (Optional) Whether to show thread info or not. Default true
//            .methodCount(1) // (Optional) How many method line to show. Default 2
//            .methodOffset(5) // Set methodOffset to 5 in order to hide internal method calls
//            .tag("") // To replace the default PRETTY_LOGGER tag with a dash (-).
//            .build()
//
//        Logger.addLogAdapter(AndroidLogAdapter(formatStrategy))
//
//
//        Timber.plant(object : Timber.DebugTree() {
//
//            override fun log(
//                priority: Int, tag: String?, message: String, t: Throwable?,
//            ) {
//                Logger.log(priority, "@@", message, t)
//            }
//        })
//    }
}

// Dependencies needed in build.gradle (app) file - Remember to update version if required.
// implementation 'com.orhanobut:logger:2.2.0'
// implementation 'com.jakewharton.timber:timber:4.7.1'
