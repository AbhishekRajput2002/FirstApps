package com.example.firstapps.threads

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.firstapps.R
import com.example.firstapps.databinding.ActivityBasicThreadBinding

class BasicThreadActivity : AppCompatActivity() {
    lateinit var binding : ActivityBasicThreadBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityBasicThreadBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.startbtn.setOnClickListener{
            val thread = Thread {
                for (i in 1..10) {
                    Thread.sleep(1000)
                    runOnUiThread {
                        binding.textview.text = i.toString()
                    }
                }
            }
            thread.start()
        }
    }
}