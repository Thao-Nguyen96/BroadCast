package com.nxt.explicitbroadcasr2

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

//trong manifet để android:exported="true" moi nhan duoc su kien

class MyBroadcastReceiver : BroadcastReceiver() {
    companion object {
        const val MY_TEXT = "text"
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        val myText = "my broadcast 2" + intent!!.getStringExtra(MY_TEXT)
        Toast.makeText(context, myText, Toast.LENGTH_SHORT).show()
    }
}