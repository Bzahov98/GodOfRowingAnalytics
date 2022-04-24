package com.bzahov.godofrowing.analytics.data.services.notification

import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Intent
import android.graphics.Bitmap
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.net.toUri
import com.bzahov.godofrowing.analytics.R
import com.bzahov.godofrowing.analytics.data.repositories.AuthRepoImpl
import com.bzahov.godofrowing.analytics.ui.activities.MainActivity
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.gson.GsonBuilder
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.concurrent.CancellationException
import javax.inject.Inject
import kotlin.random.Random

@AndroidEntryPoint
class MyFirebaseMessagingService @Inject constructor() : FirebaseMessagingService() {

    @Inject
    lateinit var authRepoImpl: AuthRepoImpl

//    @Inject
//    lateinit var notifyRepoImpl: NotifyRepoImpl
//
//    @Inject
//    lateinit var postRepoImpl: PostRepoImpl

    private val job = SupervisorJob()

//    private val notifyHelper = NotificationHelper()
//
//    private val gson = GsonBuilder().registerTypeAdapter(
//        Notify::class.java, NotifyDeserializer()
//    ).create()

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        CoroutineScope(job).launch {
            try {
                authRepoImpl.updateTokenUser(token)
            } catch (e: Exception) {
                when (e) {
                    is CancellationException -> throw e
                    is NullPointerException -> Timber.e("Error al actualizar el toke, el usuario es nulo")
                    else -> Timber.e("Error desconocido al actializar token $e")
                }
            }
        }
    }
    private inner class NotificationHelper {

        private val context
            get() = this@MyFirebaseMessagingService

//        private fun getBaseNotification(typeNotify: TypeNotify) =
//            when (typeNotify) {
//                LIKE -> NotificationCompat.Builder(context,
//                    ID_CHANNEL_POST_NOTIFY)
//                    .setAutoCancel(true)
//                    .setOngoing(false)
//                    .setSmallIcon(R.drawable.ic_fav)
//                    .setContentTitle(context.getString(R.string.text_content_notify_like))
//                COMMENT -> NotificationCompat.Builder(context,
//                    ID_CHANNEL_POST_NOTIFY)
//                    .setAutoCancel(true)
//                    .setOngoing(false)
//                    .setSmallIcon(R.drawable.ic_comment)
//                    .setContentTitle(context.getString(R.string.text_content_notify_comment))
//            }


        private fun getPendingIntentCompose(idPost: String): PendingIntent {
            // * create deep link
            // * this go to post for notification
            val deepLinkIntent = Intent(Intent.ACTION_VIEW,
                "https://www.blog-compose.com/post/$idPost".toUri(),
                context,
                MainActivity::class.java)
            // * create pending intent compose
            val deepLinkPendingIntent = TaskStackBuilder.create(context).run {
                addNextIntentWithParentStack(deepLinkIntent)
                getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)
            }
            return deepLinkPendingIntent
        }

//        private fun createCustomNotification(
//            bitmapUser: Bitmap,
//            bitmapPost: Bitmap,
//            nameUserLiked: String,
//            typeNotify: TypeNotify,
//        ): RemoteViews {
//            val (title, body) = when (typeNotify) {
//                LIKE -> Pair(
//                    context.getString(R.string.text_title_notify_like),
//                    context.getString(R.string.message_notify_liked, nameUserLiked))
//                COMMENT -> Pair(
//                    context.getString(R.string.text_title_notify_comment),
//                    context.getString(R.string.message_notify_comment, nameUserLiked))
//            }
//            return RemoteViews(context.packageName, R.layout.notify_liked).apply {
//                setImageViewBitmap(R.id.img_user_liked, bitmapUser)
//                setImageViewBitmap(R.id.img_post_liked, bitmapPost)
//                setTextViewText(R.id.text_date_notify, System.currentTimeMillis().toFormat(context))
//                setTextViewText(R.id.title, title)
//                setTextViewText(R.id.text, body)
//            }
//        }


//        fun launchNotifyPost(
//            bitmapPost: Bitmap,
//            bitmapUser: Bitmap,
//            nameUserLiked: String,
//            idPost: String,
//            typeNotify: TypeNotify,
//        ) {
//            // * create notification channel amd get notification manager
//            val notificationManager = NotificationChannelHelper.createChannelNotification(
//                idNotificationChannel = ID_CHANNEL_POST_NOTIFY,
//                nameNotificationChanel = context.getString(NAME_CHANNEL_LIKE),
//                importance = NotificationManagerCompat.IMPORTANCE_HIGH,
//                context = context
//            )
//            // * get base notify if is like or comment
//            val baseNotify = getBaseNotification(typeNotify)
//            // * create action to click on notification
//            val deepLinkPendingIntent = getPendingIntentCompose(idPost)
//            // * create custom notification
//            baseNotify.setContentIntent(deepLinkPendingIntent).also {
//                val customNotify = createCustomNotification(
//                    bitmapUser = bitmapUser,
//                    bitmapPost = bitmapPost,
//                    nameUserLiked = nameUserLiked,
//                    typeNotify = typeNotify)
//                it.setCustomContentView(customNotify)
//            }
//            // * notify with random id
//            notificationManager.notify(Random.nextInt(), baseNotify.build())
//        }
    }

}
