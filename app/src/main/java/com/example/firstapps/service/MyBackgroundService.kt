package com.example.firstapps.service

import android.app.Service
import android.content.Intent
import android.nfc.Tag
import android.os.Binder
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.util.Log
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.random.Random

class MyBackgroundService : Service() {

    private var bool = false
    private var scope = CoroutineScope(Dispatchers.IO)
    var binder = ServiceBinder()
    var IBinder = binder
    override fun onCreate() {
        Toast.makeText(this, "Service Created", Toast.LENGTH_SHORT).show()
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        bool = true
        scope.launch {
            randomNumber()
        }

        return START_STICKY
    }
    private suspend fun randomNumber()
    {
        while (bool)
        {
            val num = Random.nextInt(1,100)
            withContext(Dispatchers.Main)
            {
                Toast.makeText(this@MyBackgroundService, "Random Number : $num", Toast.LENGTH_SHORT).show()

            }
           delay(1000)
        }
    }
    override fun onBind(intent: Intent?): IBinder? {
        scope.launch {
            randomNumber()
        }
        return IBinder
        Toast.makeText(this,"Service Bound",Toast.LENGTH_SHORT).show()
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Toast.makeText(this, "Service Unbound", Toast.LENGTH_SHORT).show()
        return super.onUnbind(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        bool = false
        scope.cancel()
        Handler(Looper.getMainLooper()).post {
            Toast.makeText(this, "Service Destroyed", Toast.LENGTH_LONG).show()
        }
    }


}
class ServiceBinder : Binder()
{

}