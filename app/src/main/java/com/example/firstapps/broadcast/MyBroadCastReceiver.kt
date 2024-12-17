package com.example.firstapps.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyBroadCastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        if (intent != null) {
            if (intent.action.equals(Intent.ACTION_AIRPLANE_MODE_CHANGED))
            {
                Toast.makeText(context, "Airplane Mode Changed", Toast.LENGTH_LONG).show()
            }
             else if(intent.action.equals("com.example.firstapps.broadcast.MyBroadCastReceiver_NOTIFICATION"))
             {
                Toast.makeText(context, intent.getStringExtra("data"), Toast.LENGTH_LONG).show()
            }
        }
    }
}