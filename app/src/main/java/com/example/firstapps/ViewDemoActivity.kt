package com.example.firstapps

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.firstapps.databinding.ActivityViewDemoBinding

class ViewDemoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityViewDemoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.submit.setOnClickListener {
            val selectSub = mutableListOf<String>()
            if (binding.java.isChecked) {
                selectSub.add(binding.java.text.toString())
            }
            if (binding.Python.isChecked) {
                selectSub.add(binding.Python.text.toString())
            }
            if (binding.kotlin.isChecked) {
                selectSub.add(binding.kotlin.text.toString())
            }
            if (binding.c.isChecked) {
                selectSub.add(binding.c.text.toString())
            }
        }
        radioGroup()
    }

    fun radioGroup() {
        binding.radiogroup.setOnCheckedChangeListener {radioGroup, checkedId ->
            when (checkedId) {
                R.id.radiomale ->Toast.makeText(this, "Selected Gender: Male", Toast.LENGTH_SHORT).show()
                R.id.radiofemale ->Toast.makeText(this, "Selected Gender: Female", Toast.LENGTH_SHORT).show()
                R.id.radioother ->Toast.makeText(this, "Selected Gender: Other", Toast.LENGTH_SHORT).show()
            }

        }
    }

}
