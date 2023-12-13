package com.example.thesweetoven.fragments

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.thesweetoven.R
import com.example.thesweetoven.adapters.CakesAdapter
import com.example.thesweetoven.adapters.DonutsAdapter
import com.example.thesweetoven.databinding.FragmentSearchBinding
import com.example.thesweetoven.dataclasses.CakesItem
import com.example.thesweetoven.dataclasses.DonutsItem

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private lateinit var donutAdapter : DonutsAdapter
    private lateinit var donutsList : MutableList<DonutsItem>

    private lateinit var cakeAdapter : CakesAdapter
    private lateinit var cakesList : MutableList<CakesItem>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentSearchBinding.inflate(layoutInflater)
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

      //  donutsList = mutableListOf()

        prepareDonutsRecyclerView()
        donutItems()
        updateDonutsItems(donutsList)

        prepareCakesRecyclerView()
        cakeItems()
        updateCakesItems(cakesList)



        Log.d("SearchFragment", "MyDonuts : $donutsList")

            //    Log.d(TAG, "MyDonuts : $donutsList" )
    }

    private fun cakeItems() {

        cakesList = mutableListOf()

        val imageId = arrayOf(
            R.drawable.spongecake,
            R.drawable.chiffoncakes,
            R.drawable.carrotcakes,
            R.drawable.passioncakes
        )

        val cakesName = arrayOf(
            "Sponge Cakes",
            "Chiffon Cakes",
            "Carrot Cakes",
            "Passion Fruit Cakes"
        )


        val cakesDesc = arrayOf(
            "Technically any recipe that contains no baking powder or baking soda, but lots of whipped eggs or egg whites is a sponge cake. ",
            "This classic American cake is a cross between a cake that has been shortened with oil, and a sponge cake",
            "Carrot Cake, like American-style butter cake, uses baking soda or baking powder for leavening.",
            "Is moist, fluffy and bursting with flavor! An easy cake made with fresh passion fruit. "
        )


        for (i in imageId.indices){

            val cakesss= CakesItem(imageId[i], cakesName[i], cakesDesc[i])
            cakesList.add(cakesss)
        }
    }

    private fun updateCakesItems(cak: MutableList<CakesItem>) {
        cakeAdapter.setCakesItem(cak)
    }

    private fun prepareCakesRecyclerView() {
        cakeAdapter = CakesAdapter()
        binding.cakesRecycler.layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
        binding.cakesRecycler.setHasFixedSize(true)
        binding.cakesRecycler.adapter = cakeAdapter
    }

    private fun prepareDonutsRecyclerView() {
        donutAdapter = DonutsAdapter()
        binding.donutsRecycler.layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
        binding.donutsRecycler.setHasFixedSize(true)
        binding.donutsRecycler.adapter = donutAdapter
    }


    private fun updateDonutsItems(donut : List<DonutsItem>) {
        donutAdapter.setDonutsItems(donut)
    }

    private fun donutItems() {

        donutsList = mutableListOf()

        val imageId = arrayOf(
            R.drawable.potatodonuts,
            R.drawable.cakedonuts,
            R.drawable.yeastdonuts,
            R.drawable.cinnamondonuts
        )

        val donutName = arrayOf(
            "Potato Donuts",
            "Cake Donuts",
            "Yeast Donuts",
            "Cinnamon Twists"
        )


        val donutDesc = arrayOf(
            "These doughnuts have a similar texture to cake doughnuts, but they're made with mashed potatoes or potato starch instead of flour. ",
            "Unlike yeast doughnuts, these have a dense base that will hold all your favorite toppings, from sprinkles to bacon (if you're into that).",
            "Also referred to as \"raised doughnuts,\" this doughnut type uses yeast as a leavener, giving it a light and airy interior. ",
            "These oddly shaped yeast doughnuts are long and twisted. "
        )


        for (i in imageId.indices){

            val donutss = DonutsItem(imageId[i],donutName[i],donutDesc[i])
            donutsList.add(donutss)
        }
    }



}