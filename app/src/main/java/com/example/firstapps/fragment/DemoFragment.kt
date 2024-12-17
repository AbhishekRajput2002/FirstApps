package com.example.firstapps.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.firstapps.R

class DemoFragment : Fragment() {
    lateinit var syndata : SyncDataWithActivity
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Toast.makeText(context, "Fragment Attached", Toast.LENGTH_LONG).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Toast.makeText(context, "Fragment onCreated", Toast.LENGTH_LONG).show()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Toast.makeText(context, "Fragment onCreatedView", Toast.LENGTH_LONG).show()
        val btn = view?.findViewById<Button>(R.id.btndemo)
        btn?.setOnClickListener {
            syndata.syncData()
        }
        return inflater.inflate(R.layout.fragment_demo, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Toast.makeText(context, "Fragment onViewCreated", Toast.LENGTH_LONG).show()
       // addFragment(FirstFragment())
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
    fun setSyncData(syncDataWithActivity: DemoFragmentActivity)
    {
        syndata = syncDataWithActivity

    }

}