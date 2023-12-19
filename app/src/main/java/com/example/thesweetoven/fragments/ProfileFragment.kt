package com.example.thesweetoven.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.thesweetoven.R
import com.example.thesweetoven.auth.LoginActivity
import com.example.thesweetoven.auth.RegisterActivity
import com.example.thesweetoven.databinding.FragmentProfileBinding
import com.google.firebase.auth.FirebaseAuth

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private lateinit var user : FirebaseAuth
    private lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentProfileBinding.inflate(layoutInflater)
        return (binding.root)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        user = FirebaseAuth.getInstance()
        navController = findNavController()

        binding.updateBtn.setOnClickListener {
            Toast.makeText(context, "Profile Updated", Toast.LENGTH_SHORT).show()
            navController.navigate(R.id.action_profileFragment_to_homeFragment)

        }


       binding.logoutTxt.setOnClickListener {
           user.signOut()
            Log.d("signal", "Button signout")
            val intent = Intent(activity, LoginActivity::class.java)
            startActivity(intent)
            requireActivity().finish()

        }



    }



}