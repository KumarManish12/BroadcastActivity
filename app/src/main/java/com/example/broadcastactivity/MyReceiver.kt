package com.example.broadcastactivity

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.util.Log
import android.widget.Toast


class MyReceiver:BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        var data = intent?.getIntExtra("count", 0)
        Toast.makeText(context, "CurrentCount $data", Toast.LENGTH_SHORT).show()
    }
}