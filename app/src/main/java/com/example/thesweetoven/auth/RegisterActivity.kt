package com.example.thesweetoven.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.thesweetoven.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegisterActivity : AppCompatActivity() {

    private lateinit var pname : TextView
    private lateinit var mail : TextView
    private lateinit var pass : TextView
    private lateinit var regreg : Button
    private lateinit var haveacc : TextView
    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        pname = findViewById(R.id.nameEt)
        mail = findViewById(R.id.emailEt)
        pass = findViewById(R.id.passEt)
        regreg = findViewById(R.id.regbtn)
        haveacc = findViewById(R.id.tvhaveacc)
        auth = Firebase.auth

        haveacc.setOnClickListener {
            startActivity((Intent(this, LoginActivity::class.java)))
        }

        regreg.setOnClickListener {
            var usermail = mail.text.toString().trim()
            var userpass = pass.text.toString().trim()

            auth.createUserWithEmailAndPassword(usermail, userpass).addOnCompleteListener {
                if (it.isSuccessful){
                    Toast.makeText(this, "Account Registered", Toast.LENGTH_SHORT).show()
                    Log.d("Succ-->", it.toString())
                    startActivity((Intent(this, LoginActivity::class.java)))

                }else{
                    Toast.makeText(this, "Failed, try again!", Toast.LENGTH_SHORT).show()
                    Log.d("Failed--->", it.toString())
                }
            }
        }


    }
}