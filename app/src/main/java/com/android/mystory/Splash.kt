package com.android.mystory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        moveToLoginScreen()
    }
    private fun moveToLoginScreen(){
        Handler(Looper.myLooper()!!).postDelayed({
            finish()
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        },1000)
    }
}