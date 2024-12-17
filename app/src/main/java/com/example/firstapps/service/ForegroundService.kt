package com.example.firstapps.service

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.firstapps.BackgroundServiceActivity
import com.example.firstapps.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.random.Random

class ForegroundService: Service() {

    private var bull = false
    private var scope= CoroutineScope(Dispatchers.IO)
    val channelId = "ForegroundService"


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel() {
        val channel = NotificationChannel(
            channelId,
            "Foreground Service Channel",
            NotificationManager.IMPORTANCE_DEFAULT
        )
        val manager = getSystemService(NotificationManager::class.java)
        manager?.createNotificationChannel(channel)
    }
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        bull = true
        val notificationIntent = Intent(this, BackgroundServiceActivity::class.java)

        val pendingIntent = PendingIntent.getActivity(this,0,notificationIntent, PendingIntent.FLAG_IMMUTABLE)

        val notification = Notification.Builder(this,channelId)
            .setContentTitle("Foreground Service")
            .setContentText("Service is running")
            .setSmallIcon(R.drawable.baseline_music_note_24)
            .setContentIntent(pendingIntent)
            .build()
        startForeground(1,notification)
        scope.launch {
            randomfun()
        }
        return START_STICKY

    }

    private suspend fun randomfun()
    {
        while(bull)
        {
            val random = Random.nextInt(1,100)
            withContext(Dispatchers.Main){ Toast.makeText(this@ForegroundService, "Random Number : $random", Toast.LENGTH_LONG).show()}
        delay(1000)
        }
    }
    override fun onDestroy() {
        bull = false
        super.onDestroy()
        scope.cancel()
    }
    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }
}