package com.example.firstapps

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Build
import android.os.Bundle
import android.os.IBinder
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.firstapps.databinding.ActivityBackgroundServiceBinding
import com.example.firstapps.service.ForegroundService
import com.example.firstapps.service.MyBackgroundService
import java.util.Objects

class BackgroundServiceActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBackgroundServiceBinding
     lateinit var connection : ServiceConnection
    var boundBull = false
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityBackgroundServiceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnstartservice.setOnClickListener{
           // startService(Intent(this, MyBackgroundService::class.java))
        // Bound Service
         //     connection =object: ServiceConnection
         //   {
         //       override fun onServiceConnected(name: ComponentName, service: IBinder) {boundBull = true}
         //       override fun onServiceDisconnected(name: ComponentName) {boundBull = false}
            //   bindService(Intent(this,MyBackgroundService::class.java),connection, BIND_AUTO_CREATE)}

            // Foreground Service

            startForegroundService(Intent(applicationContext, ForegroundService::class.java))
           }
        binding.btnstopservice.setOnClickListener{
            //stopService(Intent(this,MyBackgroundService::class.java))

            // Bound Service
         //   unbindService(connection)
         //   boundBull = false

            stopService(Intent(applicationContext,ForegroundService::class.java)) // Foreground Service
        }
    }
}