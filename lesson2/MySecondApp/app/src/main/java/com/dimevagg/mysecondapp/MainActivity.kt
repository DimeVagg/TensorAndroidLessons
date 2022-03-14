package com.dimevagg.mysecondapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun count(view: View) {
        val textView = findViewById<TextView>(R.id.textview)
        val countString = textView.text.toString()
        var countInt: Int = Integer.parseInt(countString)
        countInt++
        textView.text = countInt.toString()
    }

    fun showToast(view: View) {
        val toast = Toast.makeText(this, "It's a Toast !", Toast.LENGTH_LONG)
        toast.show()
    }

    fun random(view: View) {
        val newIntent = Intent(this, SecondaryActivity::class.java)
        val textView = findViewById<TextView>(R.id.textview)
        val countString = textView.text.toString()
        val count: Int = Integer.parseInt(countString)
        newIntent.putExtra(SecondaryActivity.MAIN_ACTIVITY_COUNT, count)
        startActivity(newIntent)
    }
}