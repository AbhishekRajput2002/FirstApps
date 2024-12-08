package com.example.firstapps

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.firstapps.databinding.ActivityAutoCompleteTextAndCardViewBinding

class AutoCompleteTextAndCardView : AppCompatActivity() {
    private lateinit var binding: ActivityAutoCompleteTextAndCardViewBinding

    var countryname = mutableListOf("India", "China", "Nepal", "Sri Lanka", "Bhutan", "Other")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAutoCompleteTextAndCardViewBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setAutoCompleteTextView()
    }
    fun setAutoCompleteTextView()
    {
        var adapter = ArrayAdapter(this, android.R.layout.select_dialog_item, countryname)
        binding.autoCompleteTextView.setAdapter(adapter)
        binding.autoCompleteTextView.threshold = 1
    }

}