package com.example.thesweetoven.adapters

import android.view.LayoutInflater
import android.view.View
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

        val isExpandable : Boolean = donut.donut_isExpandable
        holder.binding.donutDescLayout.visibility = if(isExpandable) View.VISIBLE else View.GONE

        holder.binding.constraintDonutLayout.setOnClickListener {
            isAnyItemExpanded(position)
            donut.donut_isExpandable = !donut.donut_isExpandable
            notifyItemChanged(position, Unit)
        }
    }

    private fun isAnyItemExpanded(position: Int) {
        val temp = donuts.indexOfFirst {
            it.donut_isExpandable
        }
        if (temp >= 0 && temp != position){
            donuts[temp].donut_isExpandable = false
            notifyItemChanged(temp, 0)
        }
    }

    override fun onBindViewHolder(
        holder: DonutsViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        if(payloads.isNotEmpty() && payloads[0] == 0){
            holder.collapseExpandedView()
        }else{
            super.onBindViewHolder(holder, position, payloads)
        }
    }

    override fun getItemCount(): Int = donuts.size

    inner class DonutsViewHolder(val binding : DonutsLayoutBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: DonutsItem){
            binding.donutTitleLayout.text = item.donuts_name
            binding.donutDescLayout.text = item.donuts_desc
            binding.donutImgLayout.setImageResource(item.donuts_img)
        }

        fun collapseExpandedView(){
            binding.donutDescLayout.visibility = View.GONE
        }
    }


    fun setDonutsItems (donut : List<DonutsItem>){
        this.donuts = donut.toMutableList()
        notifyDataSetChanged()
    }
}




