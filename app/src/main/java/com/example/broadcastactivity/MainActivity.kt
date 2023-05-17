package com.example.broadcastactivity

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.broadcastactivity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    lateinit var myReceiver: MyReceiver
    var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        myReceiver=MyReceiver()
        var intentFilter = IntentFilter("Hello")
        registerReceiver(myReceiver,intentFilter)
        binding.btntestBroadcast.setOnClickListener {

            val intent=Intent("Hello")
            intent.putExtra("count",count++)
            sendBroadcast(intent)
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(myReceiver)
    }
}