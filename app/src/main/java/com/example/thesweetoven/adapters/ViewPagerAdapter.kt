package com.example.thesweetoven.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.thesweetoven.R

data class ViewPagerAdapter (
    private var title : List<String>,
    private var desc : List<String>,
    private var images : List<Int>,
): RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
          return ViewPagerViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.onboard_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        holder.itemTitle.text = title[position]
        holder.itemDesc.text = desc[position]
        holder.itemImage.setImageResource(images[position])

    }

    override fun getItemCount(): Int {
        return title.size
    }

    inner class ViewPagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val itemTitle: TextView = itemView.findViewById(R.id.tvtitle)
        val itemDesc: TextView = itemView.findViewById(R.id.tvdescription)
        val itemImage: ImageView = itemView.findViewById(R.id.imageView2)
    }
}