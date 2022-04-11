    package com.dimevagg.lesson4

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.media.MediaPlayer
import android.widget.Toast

class MyMusicService : Service() {

    var mediaPlayer: MediaPlayer? = null

    override fun onBind(intent: Intent): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if(mediaPlayer == null)
            mediaPlayer = MediaPlayer.create(this, R.raw.you_got_served)
        mediaPlayer?.start()
        return START_STICKY
    }
    override fun onCreate() {
        super.onCreate()
    }

    override fun onDestroy() {
        mediaPlayer?.stop()
        super.onDestroy()
    }
}