package com.nxt.explicitbroadcast3

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyBroadcast3: BroadcastReceiver() {

    companion object {
        const val MY_TEXT = "text"
        const val MY_ACTION = "action"
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        val myText = "my broadcast 3" + intent!!.getStringExtra(MY_TEXT)
        Toast.makeText(context, myText, Toast.LENGTH_LONG).show()
    }
}