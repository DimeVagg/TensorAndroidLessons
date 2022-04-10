package com.dimevagg.lesson4

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.content.ContextCompat

class MainActivity2 : AppCompatActivity() {

    var serviceIntent : Intent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        if(serviceIntent == null)
            serviceIntent = Intent(this, MyMusicService::class.java)
        startService(serviceIntent)
    }

    fun StopService(view: View) {
        var button = view as Button
        button.setTextColor(ContextCompat.getColor(this, R.color.teal_700))
        stopService(serviceIntent)
    }
}