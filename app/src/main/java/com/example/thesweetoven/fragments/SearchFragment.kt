package com.example.thesweetoven.fragments


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.thesweetoven.R
import com.example.thesweetoven.adapters.CakesAdapter
import com.example.thesweetoven.adapters.CupcakesAdapter
import com.example.thesweetoven.adapters.DonutsAdapter
import com.example.thesweetoven.adapters.PancakesAdapter
import com.example.thesweetoven.databinding.FragmentSearchBinding
import com.example.thesweetoven.dataclasses.CakesItem
import com.example.thesweetoven.dataclasses.CupcakesItem
import com.example.thesweetoven.dataclasses.DonutsItem
import com.example.thesweetoven.dataclasses.PancakesItem


class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding

    private lateinit var donutAdapter: DonutsAdapter
    private lateinit var cakeAdapter: CakesAdapter
    private lateinit var cupcakeAdapter: CupcakesAdapter
    private lateinit var pancakesAdapter: PancakesAdapter

    private lateinit var donutsList: MutableList<DonutsItem>
    private lateinit var cakesList: MutableList<CakesItem>
    private lateinit var cupcakeList: MutableList<CupcakesItem>
    private lateinit var pancakesList : MutableList<PancakesItem>



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

        donutItems()
        updateDonutsItems(donutsList)
        prepareDonutsRecyclerView()


      //  cakesList = mutableListOf()
        cakeItems()
        updateCakesItems(cakesList)
        prepareCakesRecyclerView()



      //  cupcakeList = mutableListOf()
        cupcakeItem()
        updateCupcakesItems(cupcakeList)
        prepareCupcakesRecyclerView()



       // pancakesList = mutableListOf()
        pancakeItem()
        updatePancakesItems(pancakesList)
        preparePancakesRecyclerView()




        Log.d("SearchFragment", "MyDonuts : $donutsList")
        Log.d("SearchFragment", "MyCupcakes : $cupcakeList")
        Log.d("SearchFragment", "MyPancakes : $pancakesList")

        //    Log.d(TAG, "MyDonuts : $donutsList" )
    }

    private fun pancakeItem() {

        pancakesList = mutableListOf()

        val imageId = arrayOf(
            R.drawable.blueberrypancakes,
            R.drawable.germanpancakes,
            R.drawable.cinnamonrollpancakes,
            R.drawable.buttermilkpancakes
        )

        val pancakeName = arrayOf(
            "Blueberry Pancakes",
            "German Pancakes",
            "Cinnamon Pancakes",
            "Buttermilk Pancakes"
        )


        val pancakeDesc = arrayOf(
            "Made with ground oats instead of wheat flour.",
            "Golden pan-style egg dish, with lots of big bubbles while baking",
            "Are fluffy pancakes that are swirled with a cinnamon-sugar mixture then drizzled with a sweet cream cheese frosting.",
            "A very light and fluffy pancake recipe that requires fresh buttermilk, but it's the best I've ever made! "
        )


        for (i in imageId.indices) {
            val pankek = DonutsItem(imageId[i], pancakeName[i], pancakeDesc[i])
            donutsList.add(pankek)
        }
    }

    private fun updatePancakesItems(pancakesss: List<PancakesItem>) {
               pancakesAdapter.setPancakesItems(pancakesss)
    }

    private fun preparePancakesRecyclerView() {
        pancakesAdapter = PancakesAdapter()
        binding.pancakesRecycler.layoutManager =
            GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
        binding.pancakesRecycler.setHasFixedSize(true)
        binding.pancakesRecycler.adapter = pancakesAdapter
    }

    private fun updateDonutsItems(donut: List<DonutsItem>) {
        donutAdapter.setDonutsItems(donut)
    }

    private fun prepareDonutsRecyclerView() {
        donutAdapter = DonutsAdapter()
        binding.donutsRecycler.layoutManager =
            GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
        binding.donutsRecycler.setHasFixedSize(true)
        binding.donutsRecycler.adapter = donutAdapter
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


        for (i in imageId.indices) {

            val donutss = DonutsItem(imageId[i], donutName[i], donutDesc[i])
            donutsList.add(donutss)
        }
    }


    private fun updateCakesItems(cak: List<CakesItem>) {
        cakeAdapter.setCakesItem(cak)
    }

    private fun prepareCakesRecyclerView() {
        cakeAdapter = CakesAdapter()
        binding.cakesRecycler.layoutManager =
            GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
        binding.cakesRecycler.setHasFixedSize(true)
        binding.cakesRecycler.adapter = cakeAdapter
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


        for (i in imageId.indices) {

            val cakesss = CakesItem(imageId[i], cakesName[i], cakesDesc[i])
            cakesList.add(cakesss)
        }
    }

    private fun updateCupcakesItems(cupkek: List<CupcakesItem>) {
        cupcakeAdapter.setCupcakesItem(cupkek)
    }


    private fun prepareCupcakesRecyclerView() {
        cupcakeAdapter = CupcakesAdapter()
        binding.cupcakesRecycler.layoutManager =
            GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
        binding.cupcakesRecycler.setHasFixedSize(true)
        binding.cupcakesRecycler.adapter = cupcakeAdapter


    }

    private fun cupcakeItem() {
        cupcakeList = mutableListOf()

        val imageId = arrayOf(
            R.drawable.redvelvetcupcakes,
            R.drawable.chocolatecupcake,
            R.drawable.strawberrycupcakes,
            R.drawable.lemoncupcakes
        )

        val cupcakesName = arrayOf(
            "RedVelvet Cupcakes",
            "Chocolate Cupcake",
            "StrawBerry Cupcakes",
            "Lemon Cupcakes"
        )


        val cupcakesDesc = arrayOf(
            "These red velvet cupcakes are mini versions of classic Red Velvet Cake, a popular offering at bakeries all across the country.",
            "Chocolate cupcakes are the ultimate party food. These are super moist and bursting with rich, chocolaty",
            "Most strawberry cake recipes ask you to use artificially flavored gelatin.",
            "These cupcakes are truly lighter than air and will melt in your mouth. "
        )


        for (i in imageId.indices) {

            val cupcakesss = CupcakesItem(imageId[i], cupcakesName[i], cupcakesDesc[i])
            cupcakeList.add(cupcakesss)
        }
    }
}





