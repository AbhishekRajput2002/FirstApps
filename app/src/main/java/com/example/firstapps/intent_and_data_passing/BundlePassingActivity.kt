package com.example.firstapps.intent_and_data_passing

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.firstapps.R
import com.example.firstapps.databinding.ActivityBundlePassingBinding

class BundlePassingActivity : AppCompatActivity() {
    lateinit var binding: ActivityBundlePassingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityBundlePassingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //intentSendData()
        //intentSendDataBundle()
        //intentUsingSerializable()
        intentUsingParselable()



    }

    private fun intentSendData() {
        binding.senddataintent.setOnClickListener {
            intent = Intent(this, IntentPassingData::class.java)
            intent.putExtra(Constants.KEY_NAME, "Abhishek Rajput Intent")
            startActivity(intent)

        }
    }
    fun intentSendDataBundle() {
        binding.senddatabundle.setOnClickListener {
            intent = Intent(this, IntentPassingData::class.java)
            val bundle = Bundle()
            bundle.putString(Constants.KEY_NAME, "Abhishek Rajput jii........ using Bundle ")
            intent.putExtra(Constants.KEY_BUNDLE, bundle)
            startActivity(intent)
        }
    }
    fun intentUsingSerializable()
    {
        binding.senddataserializable.setOnClickListener {
            intent = Intent(this, IntentPassingData::class.java)
            val student = Student("Abhishek Rajput Using Serializable")
            intent.putExtra(Constants.KEY_SERIALIZABLE, student)
            startActivity(intent)
        }
    }

    fun intentUsingParselable()
    {
        binding.senddataparselable.setOnClickListener {
            intent = Intent(this, IntentPassingData::class.java)
            val student = StudentParcelable("Abhishek using Parcelable")
            intent.putExtra(Constants.KEY_PARCELABLE, student)
            startActivity(intent)
        }
    }
}
