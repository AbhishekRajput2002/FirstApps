package com.example.firstapps

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.firstapps.databinding.ActivityIntentBinding
import com.example.firstapps.databinding.ActivitySpinnerProgressBarBinding

class IntentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIntentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityIntentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    openActivity()
        openURL()
        call()
        sendMessage()
    }

    private fun openActivity()
    {
        binding.startdemoactivity.setOnClickListener {

            val intent = Intent(this, ViewDemoActivity::class.java)
            startActivity(intent)
        }
    }
    fun openURL()
    {
        binding.openurl.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = android.net.Uri.parse("https://www.google.com")
            startActivity(intent)
        }
    }
    fun call()
    {
        binding.call.setOnClickListener {
            intent = Intent(Intent.ACTION_DIAL)
            intent.data = android.net.Uri.parse("tel:9876543210")
            startActivity(intent)
        }
    }
    fun sendMessage()
    {
            binding.sendmessage.setOnClickListener {
             //  val message = Intent(Intent.ACTION_SEND)
             //   message.setType("text/plain")
             //   message.putExtra(Intent.EXTRA_TEXT,"https://www.google.co.in/")
             //   startActivity(Intent.createChooser(message, "Choose App"))

                val message = Intent(Intent.ACTION_SENDTO)
                message.data= android.net.Uri.parse("smsto:"+android.net.Uri.encode("9876543210"))
                message.putExtra(Intent.EXTRA_TEXT, "Hello my name is Abhishek")
                startActivity(Intent.createChooser(message,"Click any Apps"))
            }
    }
}







