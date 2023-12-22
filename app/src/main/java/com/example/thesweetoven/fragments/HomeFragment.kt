package com.example.thesweetoven.fragments

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.thesweetoven.R
import com.example.thesweetoven.adapters.DiscoverAdapter
import com.example.thesweetoven.dataclasses.DiscoverItem
import com.example.thesweetoven.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var navController: NavController
    private lateinit var discadapter: DiscoverAdapter
    private lateinit var discoverList: MutableList<DiscoverItem>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return (binding.root)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = findNavController()

        binding.btnExplore.setOnClickListener {
            navController.navigate(R.id.action_homeFragment_to_searchFragment)

            Log.d("ExBtn", "Button Clicked")
        }


        discoverItems()
        prepareRecyclerView()
        updateDiscoverItems(discoverList)



        Log.d(TAG, "MYLIST : ${discoverList}" )


    }


    private fun updateDiscoverItems(discover: List<DiscoverItem>) {
        discadapter.setDiscoverItems(discover)
    }

    //remove navcontroller from inside the () of discoveradapter
    private fun prepareRecyclerView() {
        discadapter = DiscoverAdapter(onItemClick = (DiscoverItem -> Unit?))
        binding.recyclerExplore.layoutManager = GridLayoutManager( context, 2, GridLayoutManager.VERTICAL, false)
        binding.recyclerExplore.setHasFixedSize(true)
        binding.recyclerExplore.adapter = discadapter
    }

    //this method is for initializing the data
    private fun discoverItems() {

        discoverList = mutableListOf()

       val imageId = arrayOf(
            R.drawable.donut,
            R.drawable.cakes,
            R.drawable.cupcakes,
            R.drawable.pancakes
        )

        val titleName = arrayOf(
            "Donuts",
            "Cakes",
            "Cupcake",
            "Pancake"
        )

       for (i in imageId.indices){

          val discoverss = DiscoverItem(imageId[i],titleName[i])
           discoverList.add(discoverss)
        }
    }
}

