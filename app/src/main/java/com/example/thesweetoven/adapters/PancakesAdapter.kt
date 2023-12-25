package com.example.thesweetoven.adapters

import android.view.LayoutInflater
import android.view.View
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

        val isExpandable : Boolean = pancak.pancakes_isExpandable
        holder.binding.pancakeDescLayout.visibility = if(isExpandable) View.VISIBLE else View.GONE

        holder.binding.constraintPancakeLayout.setOnClickListener {
            isAnyItemExpanded(position)
            pancak.pancakes_isExpandable = !pancak.pancakes_isExpandable
            notifyItemChanged(position, Unit)
        }
    }

    private fun isAnyItemExpanded(position: Int) {
        val temp = pancakes.indexOfFirst {
            it.pancakes_isExpandable
        }
        if (temp >= 0 && temp != position){
            pancakes[temp].pancakes_isExpandable = false
            notifyItemChanged(temp, 0)
        }
    }

    override fun onBindViewHolder(
        holder: PancakesViewHolder,
        position: Int,
        payloads: MutableList<Any>,
    ) {

        if(payloads.isNotEmpty() && payloads[0] == 0){
            holder.collapseExpandedView()
        }else{
            super.onBindViewHolder(holder, position, payloads)
        }
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

        fun collapseExpandedView() {
            binding.constraintPancakeLayout.visibility = View.GONE
        }

    }
}