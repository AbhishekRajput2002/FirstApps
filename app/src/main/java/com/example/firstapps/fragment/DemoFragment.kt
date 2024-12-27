package com.example.firstapps.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.firstapps.R
import com.example.firstapps.databinding.FragmentDemoBinding

class DemoFragment : Fragment() {
    lateinit var binding: FragmentDemoBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Toast.makeText(context, "Fragment Attached", Toast.LENGTH_LONG).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        Toast.makeText(context, "Fragment onCreated", Toast.LENGTH_LONG).show()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Toast.makeText(context, "Fragment onCreatedView", Toast.LENGTH_LONG).show()
        binding = FragmentDemoBinding.inflate(inflater, container, false)
        binding.btnsetting.setOnClickListener {
            val action = DemoFragmentDirections.actionDemoFragmentToSecondFragment("Abhishek Rajput")
            findNavController().navigate(action)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Toast.makeText(context, "Fragment onViewCreated", Toast.LENGTH_LONG).show()
       // addFragment(FirstFragment())
        setListner()
    }

  //  private fun addFragment(fragment: Fragment)
  //  {
  //      childFragmentManager.beginTransaction()
   //         .add(R.id.firstfragment,fragment)
   //         .commit()
   // }

    override fun onStart() {
        super.onStart()
        Toast.makeText(context, "Fragment onStarted", Toast.LENGTH_LONG).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(context, "Fragment onResumed", Toast.LENGTH_LONG).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(context, "Fragment onPaused", Toast.LENGTH_LONG).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(context, "Fragment onStopped", Toast.LENGTH_LONG).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Toast.makeText(context, "Fragment onDestroyView", Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(context, "Fragment onDestroy", Toast.LENGTH_LONG).show()
    }

    override fun onDetach() {
        super.onDetach()
        Toast.makeText(context, "Fragment onDetach", Toast.LENGTH_LONG).show()
    }
    private fun setListner(){
        binding.btn1.setOnClickListener()
        {
            findNavController().navigate(R.id.action_demoFragment_to_firstFragment)
        }
        binding.btn2.setOnClickListener()
        {
            findNavController().navigate(R.id.action_demoFragment_to_secondFragment)
        }

    } override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.my_menu, menu) // Menu को Inflate करें
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.home -> {
                Toast.makeText(requireContext(), "Home Clicked in Fragment", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.setting -> {
                Toast.makeText(requireContext(), "Settings Clicked in Fragment", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.logout -> {
                Toast.makeText(requireContext(), "Logout Clicked in Fragment", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}