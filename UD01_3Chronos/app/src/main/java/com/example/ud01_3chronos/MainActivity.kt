package com.example.ud01_3chronos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.os.SystemClock
import android.widget.Button
import android.widget.Chronometer

class MainActivity : AppCompatActivity() {
    lateinit var chrono: Chronometer
    var running =false
    val RUNNING_KEY="running"
    val OFFSET_KEY ="offset"
    val BASE_KEY ="base"
    var offSet = 0L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        chrono = findViewById<Chronometer>(R.id.chrono)

        if (savedInstanceState!=null){
            offSet = savedInstanceState.getLong(OFFSET_KEY)
            running = savedInstanceState.getBoolean(RUNNING_KEY)
            if (running){
                chrono.base = savedInstanceState.getLong(BASE_KEY)
                chrono.start()
            }
            else{
                chrono.base=SystemClock.elapsedRealtime()-offSet
            }
        }


        val btnStart = findViewById<Button>(R.id.btn_start)
        val btnPause = findViewById<Button>(R.id.btn_pause)
        val btnRestart = findViewById<Button>(R.id.btn_restart)
        btnStart.setOnClickListener {
            if (!running){
                chrono.base=SystemClock.elapsedRealtime() - offSet
                chrono.start()
                running = true
            }
        }

        btnPause.setOnClickListener{
            if (running){
                chrono.stop()
                offSet = SystemClock.elapsedRealtime()-chrono.base
                running=false
            }
        }
        btnRestart.setOnClickListener {
                offSet = 0L
                chrono.base = SystemClock.elapsedRealtime()
                chrono.start()
                running = true

        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putBoolean(RUNNING_KEY,running)
        outState.putLong(OFFSET_KEY,offSet)
        outState.putLong(BASE_KEY,chrono.base)
        super.onSaveInstanceState(outState)
    }

    override fun onStop() {
        if (running){
            offSet = SystemClock.elapsedRealtime() -chrono.base
            chrono.stop()
        }
        super.onStop()
    }

    override fun onRestart() {
        if (running){
            chrono.base = SystemClock.elapsedRealtime() - offSet
            chrono.start()
        }
        super.onRestart()
    }

    override fun onResume() {
        if (running){
            chrono.base = SystemClock.elapsedRealtime() - offSet
            chrono.start()
        }
        super.onResume()

    }
}