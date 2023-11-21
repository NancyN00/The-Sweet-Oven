package com.example.thesweetoven.onboard_page

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.viewpager2.widget.ViewPager2
import com.example.thesweetoven.R
import com.example.thesweetoven.adapters.ViewPagerAdapter
import com.example.thesweetoven.auth.RegisterActivity
import me.relex.circleindicator.CircleIndicator3

class ImageSliderActivity : AppCompatActivity() {

    private var titlesList = mutableListOf<String>()
    private var descList = mutableListOf<String>()
    private var imagesList = mutableListOf<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_slider)

        //hide status bar

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()

        val skip = findViewById<Button>(R.id.skipbtn)
        postToList()

        //set the adapter inside the pager
        val view_pager2 = findViewById<ViewPager2>(R.id.view_page2)
        view_pager2.adapter = ViewPagerAdapter(titlesList, descList, imagesList)

        //implement the indicator

        val indicator = findViewById<CircleIndicator3>(R.id.indicator)
        indicator.setViewPager(view_pager2)

        //set onclick listener fo the button

        skip.setOnClickListener {
            val i = Intent(this@ImageSliderActivity, RegisterActivity::class.java)
            startActivity(i)
        }

    }

   private fun addToList(title: String, desc: String, images:Int){
       titlesList.add(title)
       descList.add(desc)
       imagesList.add(images)
   }

    private fun postToList() {
        addToList(
            "Made with Care & Love",
            "Welcome into our bakery!",
            R.drawable.homemade
        )

        addToList(
            "Deliver to your footstep",
            "We make deliveries 24/7. Place your orders and we will bring it to you!",
            R.drawable.delivery
        )

        addToList(
            "Freshly baked",
            "Made with fresh ingredients.",
            R.drawable.baked
        )
    }
}
