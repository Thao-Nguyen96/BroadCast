package com.nxt.delegation

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.widget.Toast

class ExampleBroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {

        //?: check null
        val isAirPlain = intent?.getBooleanExtra("state", false) ?: return

        if (isAirPlain){
            Toast.makeText(context, "Chế độ máy bay", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(context, "Bỏ chế đố máy bay", Toast.LENGTH_LONG).show()
        }
    }
}