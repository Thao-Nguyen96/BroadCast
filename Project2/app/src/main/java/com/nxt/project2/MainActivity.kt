package com.nxt.project2

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonIOException
import com.google.gson.JsonObject
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    companion object {
        const val MY_ACTION = "main"

        //key để truyền dữ liệu qua project 2
        const val MY_USER = "user"
    }

    //khai bao broadcast de nhan su kien

    private val mBroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            if (MY_ACTION == intent!!.action) {
                // val jsonUser = intent.getStringExtra(MY_USER)

                val strJson = intent.getStringExtra(MY_USER)
                val list: ArrayList<User> = getListUser(strJson!!)

                Log.d("aaa", list.size.toString())

                var listUserName = ""

                for (i in 0 until list.size) {
                    listUserName = listUserName +list[i].name + "\n"
                }

               // val gson = Gson()
                // val user = gson.fromJson(jsonUser, User::class.java)
                tv.text = listUserName

            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()

        val intentFilter = IntentFilter(MY_ACTION)
        registerReceiver(mBroadcastReceiver, intentFilter)
    }

    override fun onDestroy() {
        super.onDestroy()

        unregisterReceiver(mBroadcastReceiver)
    }

    //convert str ra list user
    private fun getListUser(strJson: String): ArrayList<User> {
        val list :ArrayList<User> =  ArrayList()

        val jsonArray = JSONArray(strJson)

        val gson = Gson()

        for (i in 0 until jsonArray.length()) {
            val jsonObject: JSONObject = jsonArray.getJSONObject(i)
            val user: User = gson.fromJson(jsonObject.toString(), User::class.java)
            list.add(user)
        }
        return list
    }
}