package com.example.firstapps

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstapps.databinding.ActivityRecycleViewBinding
import com.example.firstapps.module.AdapterRecyclearView
import com.example.firstapps.module.PersonData

class RecycleViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecycleViewBinding
    private var personList = mutableListOf<PersonData>()
    private var adapter = AdapterRecyclearView(personList,this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecycleViewBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        RecyclearViewData()
    }

    private fun RecyclearViewData() {
        personList.add(PersonData("Rajesh","01/01/2002",R.drawable.profile))
        personList.add(PersonData("Abhi","07/03/2003",R.drawable.progile1))
        personList.add(PersonData("Payu","12/06/2006",R.drawable.profile2))
        personList.add(PersonData("Abhishek","22/01/2007",R.drawable.profile3))
        personList.add(PersonData("Alankar","01/07/2009",R.drawable.profile))
        personList.add(PersonData("Rajesh","05/09/2004",R.drawable.progile1))
        personList.add(PersonData("Rupesh","09/04/2006",R.drawable.profile2))
        personList.add(PersonData("Saksham","22/09/2008",R.drawable.profile3))
        personList.add(PersonData("Sonu","05/7/2015",R.drawable.profile))
        personList.add(PersonData("Rajesh","15/11/2012",R.drawable.progile1))
        personList.add(PersonData("Abhishek","3/01/2023",R.drawable.profile2))
        personList.add(PersonData("Monu","01/5/2002",R.drawable.profile3))

    binding.recycleview.layoutManager = LinearLayoutManager(this)
        binding.recycleview.adapter = adapter
    }
}