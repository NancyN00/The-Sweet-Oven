package com.example.thesweetoven.auth

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.thesweetoven.R
import com.example.thesweetoven.home.HomeFragment

class LoginActivity : AppCompatActivity() {

    private lateinit var usermail : TextView
    private lateinit var userpas: TextView
    private lateinit var login : Button
    private lateinit var nocount : TextView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        usermail = findViewById(R.id.emailEt)
        userpas = findViewById(R.id.passEt)
        nocount = findViewById(R.id.noaccountt)
        login = findViewById(R.id.loginbtn)

        login.setOnClickListener {
            startActivity((Intent(this, HomeFragment::class.java)))
        }

        nocount.setOnClickListener {
            startActivity((Intent(this, RegisterActivity::class.java)))
        }




    }
}