package com.example.firstapps.fragment

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.firstapps.R
import com.example.firstapps.databinding.ActivityDemoFragmentBinding

class DemoFragmentActivity : AppCompatActivity(), SyncDataWithActivity {
    private lateinit var binding: ActivityDemoFragmentBinding
  //  var demoFragment = DemoFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDemoFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //  addFragment(DemoFragment())
        addAllFragment()
    }

    fun addFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentlayout, fragment)
            .addToBackStack(null)
            .commit()

    }

    private fun addAllFragment() {
        binding.btndemo.setOnClickListener {
            addFragment(DemoFragment())
        }
        binding.btnfirst.setOnClickListener {
            addFragment(FirstFragment())
        }
        binding.btnsecond.setOnClickListener {
            addFragment(SecondFragment())
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    override fun syncData() {
        Toast.makeText(this, "Data Synced", Toast.LENGTH_SHORT).show()
    }


}
