package com.example.thesweetoven.auth

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.TextView
import com.example.thesweetoven.R
import com.example.thesweetoven.ui.HomeActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    private lateinit var usermail: TextView
    private lateinit var userpas: TextView
    private lateinit var login: Button
    private lateinit var nocount: TextView
    private lateinit var firebase: FirebaseAuth

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //initialize the variables
        usermail = findViewById(R.id.emailEt)
        userpas = findViewById(R.id.passEt)
        nocount = findViewById(R.id.noaccountt)
        login = findViewById(R.id.loginbtn)
        firebase = Firebase.auth

        //usermail is used as reference to editext in the widget
        //usermail.text  retrieves the text entered by the user in the edittext field
        //tostring() is used to convert the editable
        //trim()function to remove leading and trailing whitespaces and then checks if the resulting string is empty

        login.setOnClickListener {
            val mail = usermail.text.toString().trim()
            val pass = userpas.text.toString().trim()

            when {
                TextUtils.isEmpty(mail) -> usermail.error = "Email is required"
                TextUtils.isEmpty(pass) -> userpas.error = "Password is required"

                else -> {
                    Intent(this@LoginActivity, HomeActivity::class.java).also {
                        startActivity(it)
                    }
                }

            }
        }
    }
        }


//Here, usermail is a TextView that was declared earlier in your code.
//The line is using findViewById to find the TextView with the resource ID. R.id.emailEt and assigns it to the usermail variable.
//This is how you associate the usermail variable in your Kotlin code with the actual TextView widget defined in your XML layout file with the ID emailEt.

