package com.example.firstapps.usefultopicsheet

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.firstapps.R
import com.example.firstapps.databinding.ActivityBottomModelSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class BottomModelSheetActivity : AppCompatActivity() {
    lateinit var binding : ActivityBottomModelSheetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityBottomModelSheetBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.modelbottomsheetbtn.setOnClickListener {
            val bottomSheetDialog = BottomSheetDialog(this)
            val view = layoutInflater.inflate(R.layout.show_model_bottom_sheet, null)
            bottomSheetDialog.setContentView(view)
            bottomSheetDialog.show()

            val button : Button = view.findViewById(R.id.modelbottomsubmit)
            button.setOnClickListener {
                bottomSheetDialog.dismiss()
            }
            bottomSheetDialog.setCancelable(false)
        }

    }
}