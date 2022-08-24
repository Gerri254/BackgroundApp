package com.gerald.backgroundservice

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast

class BackgroundService : Service() {
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        onTaskRemoved(intent)
        Toast.makeText(applicationContext,"Uploading",Toast.LENGTH_SHORT).show()
        //all logic will go here
        return START_STICKY//STAYS THERE
        //return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent): IBinder? {
      return null;
    }

    override fun onTaskRemoved(rootIntent: Intent?) {
        val intentRestart = Intent (applicationContext,this.javaClass)
        intentRestart.setPackage("com.gerald.backgroundservice")
        startService(intentRestart)
        super.onTaskRemoved(rootIntent)//want ever 2 be running
    }
}
//youtube tutorial-android service kotlin application