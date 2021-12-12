package com.nxt.custombroadcast1

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object{
        const val MY_ACTION = "main"
        const val MY_TEXT = "text"
    }

    private val mBroadcastReceiver =object :BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            if (MY_ACTION == intent!!.action){
                val text = intent.getStringExtra(MY_TEXT)
                tv.text = text
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_send_broadcast.setOnClickListener {
            clickSendBroadcast()
        }
    }

    private fun clickSendBroadcast() {
        val intent = Intent(MY_ACTION)
        intent.putExtra(MY_TEXT, "my name is xuan Thao")
        sendBroadcast(intent)
    }

    //đăng kí nhận broadcast
    override fun onStart() {
        super.onStart()

        val intentFilter = IntentFilter(MY_ACTION)
        registerReceiver(mBroadcastReceiver, intentFilter)
    }

    override fun onStop() {
        super.onStop()

        unregisterReceiver(mBroadcastReceiver)
    }
}