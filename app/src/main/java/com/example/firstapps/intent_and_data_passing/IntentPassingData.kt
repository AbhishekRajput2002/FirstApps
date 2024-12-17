package com.example.firstapps.intent_and_data_passing

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.firstapps.R
import com.example.firstapps.databinding.ActivityIntentPassingDataBinding
import java.io.Serializable

class IntentPassingData : AppCompatActivity() {
    private lateinit var binding: ActivityIntentPassingDataBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityIntentPassingDataBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Use only Intent
          //  val name =intent.getStringExtra(Constants.KEY_NAME)
          //    binding.intentdata.text="name : $name"

        // Use Bundle passing
           // val bundle = intent.getBundleExtra(Constants.KEY_BUNDLE)
           // val namebundle = bundle?.getString(Constants.KEY_NAME)
           // binding.intentdata.text = "name : $namebundle"

        // Use Serializable
           // val serializable = intent.getSerializableExtra(Constants.KEY_SERIALIZABLE) as Student
           // binding.intentdata.text = "name :${serializable.name}"

        // Use Parselable

        val parselable = intent.getParcelableExtra<StudentParcelable>(Constants.KEY_PARCELABLE)
        binding.intentdata.text = "name :${parselable?.name}"


    }
}