package com.nxt.project1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val MY_ACTION = "main"

        //key để truyền dữ liệu qua project 2
        const val MY_USER = "user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_send.setOnClickListener {
            clickSendBroad()
        }
    }

    private fun clickSendBroad() {
        val intent = Intent(MY_ACTION)
        val user1 = User(1, "Thao")
        val user2 = User(2, "Huyen")

        val listUser: ArrayList<User> = ArrayList()

        listUser.add(user1)
        listUser.add(user2)

        val gson = Gson()
        val jsonArray = gson.toJsonTree(listUser).asJsonArray
        val strJson = jsonArray.toString()

        intent.putExtra(MY_USER, strJson)

        //send object
//        val jsonUser = gson.toJson(user)
//        intent.putExtra(MY_USER, jsonUser)

        sendBroadcast(intent)
        Toast.makeText(this, "send broadcast success", Toast.LENGTH_LONG).show()
    }
}