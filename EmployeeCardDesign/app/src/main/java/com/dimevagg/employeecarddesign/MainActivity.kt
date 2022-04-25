package com.dimevagg.employeecarddesign

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuInflater
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.widget.PopupMenu
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.videocallButton).setOnClickListener {
            Toast.makeText(this, R.string.contactessage, Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.extEmailButton).setOnClickListener {
            Toast.makeText(this, R.string.contactessage, Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.intEmailButton).setOnClickListener {
            Toast.makeText(this, R.string.contactessage, Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.phoneButton).setOnClickListener {
            Toast.makeText(this, R.string.contactessage, Toast.LENGTH_SHORT).show()
        }

        findViewById<ImageView>(R.id.geo).setOnClickListener {
            Toast.makeText(this, R.string.russia, Toast.LENGTH_SHORT).show()
        }

        findViewById<ImageView>(R.id.achievementButton1).setOnClickListener {
            Toast.makeText(this, R.string.cube, Toast.LENGTH_SHORT).show()
        }

        findViewById<ImageView>(R.id.achievementButton2).setOnClickListener {
            Toast.makeText(this, R.string.flag, Toast.LENGTH_SHORT).show()
        }

        findViewById<ImageView>(R.id.achievementButton3).setOnClickListener {
            Toast.makeText(this, R.string.flight, Toast.LENGTH_SHORT).show()
        }

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            //Toast.makeText(this, R.string.call, Toast.LENGTH_SHORT).show()
            showPopup(it)
        }
    }

    fun showPopup(v: View) {
        val popup = PopupMenu(this, v)
        val inflater: MenuInflater = popup.menuInflater
        inflater.inflate(R.menu.actions, popup.menu)
        popup.show()
    }
}
