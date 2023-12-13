package com.example.thesweetoven.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.thesweetoven.databinding.DonutsLayoutBinding
import com.example.thesweetoven.dataclasses.DonutsItem

class DonutsAdapter : RecyclerView.Adapter<DonutsAdapter.DonutsViewHolder>() {

    private var donuts = mutableListOf<DonutsItem>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DonutsViewHolder {
       val inflater = LayoutInflater.from(parent.context)
        val binding = DonutsLayoutBinding.inflate(inflater, parent, false)
        return  DonutsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DonutsViewHolder, position: Int) {
        val donut = donuts[position]
        holder.bind(donut)
    }

    override fun getItemCount(): Int = donuts.size

    inner class DonutsViewHolder(private val binding : DonutsLayoutBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: DonutsItem){
            binding.donutTitleLayout.text = item.donuts_name
            binding.donutDescLayout.text = item.donuts_desc
            binding.donutImgLayout.setImageResource(item.donuts_img)
        }
    }
    fun setDonutsItems (donut : List<DonutsItem>){
        this.donuts = donut.toMutableList()
        notifyDataSetChanged()
    }
}