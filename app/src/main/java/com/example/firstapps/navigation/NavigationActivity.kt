package com.example.firstapps.navigation

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.ViewParent
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.firstapps.R
import com.example.firstapps.adapter.LayoutAdapter
import com.example.firstapps.databinding.ActivityNavigationBinding
import com.google.android.material.tabs.TabLayout

class NavigationActivity : AppCompatActivity(), TabLayout.OnTabSelectedListener {
    lateinit var binding: ActivityNavigationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        bottomNavigation()
           supportActionBar?.title = "First App"
     //   tabLayout()
    }

    private fun  tabLayout() {
        binding.tablayout.addTab(binding.tablayout.newTab().setText("Home"))
        binding.tablayout.addTab(binding.tablayout.newTab().setText("Settings"))
        binding.tablayout.addTab(binding.tablayout.newTab().setText("Profile"))

        val adapter = LayoutAdapter(supportFragmentManager,binding.tablayout.tabCount)
        binding.viewpager.adapter=adapter
        binding.viewpager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(binding.tablayout))
        binding.tablayout.addOnTabSelectedListener(this)
    }

    fun bottomNavigation() {
        binding.bottomnavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    Toast.makeText(this, "Home Clicked", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.setting -> {
                    Toast.makeText(this, "Settings Clicked", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.profile -> {
                    Toast.makeText(this, "Logout Clicked", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> {
                    false
                }
            }

        }
    }

    override fun onTabSelected(tab: TabLayout.Tab?) {
        binding.viewpager.currentItem = tab!!.position
    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {
        println(" Tab Unselected : ${tab?.text}")
    }

    override fun onTabReselected(tab: TabLayout.Tab?) {
        println(" Tab Reselected : ${tab?.text}")

    }

}