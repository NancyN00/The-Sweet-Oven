package com.example.thesweetoven.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.thesweetoven.databinding.DonutsLayoutBinding
import com.example.thesweetoven.databinding.PancakesLayoutBinding
import com.example.thesweetoven.dataclasses.PancakesItem

class PancakesAdapter : RecyclerView.Adapter<PancakesAdapter.PancakesViewHolder>() {

    private var pancakes = mutableListOf<PancakesItem>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PancakesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = PancakesLayoutBinding.inflate(inflater, parent, false)
        return  PancakesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PancakesViewHolder, position: Int) {
        val pancak = pancakes[position]
        holder.bind(pancak)
    }

    fun setPancakesItems(pancakk: List<PancakesItem>){
        this.pancakes = pancakk.toMutableList()
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int = pancakes.size

    inner class PancakesViewHolder (val binding: PancakesLayoutBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(pancakk: PancakesItem) {
             binding.pancakeTitleLayout.text = pancakk.pancakes_name
            binding.pancakeDescLayout.text = pancakk.pancakes_desc
            binding.pancakeImgLayout.setImageResource(pancakk.pancakes_img)
        }

    }
}