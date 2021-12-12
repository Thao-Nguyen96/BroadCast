package com.nxt.explicitbroadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyBroadcastReceiver: BroadcastReceiver() {

    companion object{
        const val MY_TEXT = "text"
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        val myText = intent!!.getStringExtra(MY_TEXT)
        Toast.makeText(context, myText, Toast.LENGTH_LONG).show()
    }
}