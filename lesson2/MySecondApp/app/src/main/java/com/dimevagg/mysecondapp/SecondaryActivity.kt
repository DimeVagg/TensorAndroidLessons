package com.dimevagg.mysecondapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.util.*

class SecondaryActivity : AppCompatActivity() {

    companion object {
        const val MAIN_ACTIVITY_COUNT = "main_activity_count"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secondary)
        updateRandom()
    }

    fun updateRandom() {
        val count = intent.getIntExtra(MAIN_ACTIVITY_COUNT, 0)
        val random = Random()
        var randomCounter = 0

        randomCounter = random.nextInt( count + 1)
        val randomInsideText = findViewById<TextView>(R.id.textview_header)
        val randomNumberLabel = findViewById<TextView>(R.id.textview_random)
        randomInsideText.text = getString(R.string.random_heading, count)
        randomNumberLabel.text = randomCounter.toString()
    }

}