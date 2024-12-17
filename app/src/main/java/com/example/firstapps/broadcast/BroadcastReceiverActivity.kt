package com.example.firstapps.broadcast

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.firstapps.R
import com.example.firstapps.databinding.ActivityBroadcastReceiverBinding

class BroadcastReceiverActivity : AppCompatActivity() {
    lateinit var binding:ActivityBroadcastReceiverBinding
    lateinit var receiver: MyBroadCastReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityBroadcastReceiverBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.sendbroadcast.setOnClickListener {
           var  intent = Intent(this,MyBroadCastReceiver::class.java)
            intent.putExtra("data","My custom broadcast receiver")
            intent.action = "com.example.firstapps.broadcast.MyBroadCastReceiver_NOTIFICATION"
            sendBroadcast(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        receiver = MyBroadCastReceiver()
        registerReceiver(receiver, IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED))
    }

    override fun onStop() {
        unregisterReceiver(receiver)
        super.onStop()
    }
}




