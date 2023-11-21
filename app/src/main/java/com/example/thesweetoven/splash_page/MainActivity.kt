package com.example.thesweetoven.splash_page

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.thesweetoven.R
import com.example.thesweetoven.auth.RegisterActivity
import com.example.thesweetoven.onboard_page.ImageSliderActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //postdelayed method is used to delay method for 3 second

        Handler().postDelayed({
            val intent = Intent(this@MainActivity, ImageSliderActivity::class.java)
               startActivity(intent)
            finish()
        }, 3000)
    }
}