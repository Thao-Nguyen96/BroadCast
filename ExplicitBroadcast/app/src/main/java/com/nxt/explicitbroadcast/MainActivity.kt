package com.nxt.explicitbroadcast

import android.content.ComponentName
import android.content.Intent
import android.content.pm.ResolveInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val MY_TEXT = "text"
        const val MY_ACTION = "action"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_send.setOnClickListener {
            clickSendBroadcast()
        }
    }

    private fun clickSendBroadcast() {
        //val intent = Intent(this, MyBroadcastReceiver::class.java)

//        val componentName = ComponentName("com.nxt.explicitbroadcasr2",
//            "com.nxt.explicitbroadcasr2.MyBroadcastReceiver")
//        intent.component = componentName
        // intent.putExtra(MY_TEXT, "My name is Thao")
//        sendBroadcast(intent)


        val intent = Intent(MY_ACTION)
        intent.putExtra(MY_TEXT, "my name is Thao")

        val packageManager = packageManager
        val resolveInfoList: List<ResolveInfo> = packageManager.queryBroadcastReceivers(intent, 0)

        for (info: ResolveInfo in resolveInfoList) {
            val componentName = ComponentName(info.activityInfo.packageName,
                info.activityInfo.name)
            intent.component = componentName
            sendBroadcast(intent)
        }

    }
}