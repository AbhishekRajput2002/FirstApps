package com.example.firstapps

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.firstapps.databinding.ActivitySingleListViewItemBinding

class SingleListViewItem : AppCompatActivity() {
 private lateinit var binding: ActivitySingleListViewItemBinding
     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding = ActivitySingleListViewItemBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
         setUpListView()
    }

    @SuppressLint("ResourceType")
    private fun setUpListView() {
        var list_name = getResources().getStringArray(R.array.country_name_listview)
        var adapter = ArrayAdapter(this,R.layout.list_view_item,list_name)
        binding.activitylistview.setAdapter(adapter)

        binding.activitylistview.setOnItemClickListener { listpodition, view, position, id ->
            Toast.makeText(this, "Selected: ${list_name[position]}", Toast.LENGTH_SHORT).show()
        }
    }
}