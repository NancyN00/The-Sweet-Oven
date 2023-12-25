package com.example.thesweetoven.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.thesweetoven.databinding.CakesLayoutBinding
import com.example.thesweetoven.databinding.DonutsLayoutBinding
import com.example.thesweetoven.dataclasses.CakesItem
import com.example.thesweetoven.dataclasses.CupcakesItem

class CakesAdapter : RecyclerView.Adapter<CakesAdapter.CakesViewHolder>() {

    private var cakes = mutableListOf<CakesItem>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CakesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CakesLayoutBinding.inflate(inflater, parent, false)
        return  CakesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CakesViewHolder, position: Int) {
        val cake = cakes[position]
        holder.bind(cake)

        val isExpandable : Boolean = cake.cakes_isExpandable
        holder.binding.cakesDescLayout.visibility = if(isExpandable) View.VISIBLE else View.GONE

        holder.binding.constraintCakesLayout.setOnClickListener {
            isAnyItemExpanded(position)
            cake.cakes_isExpandable = !cake.cakes_isExpandable
            notifyItemChanged(position, Unit)
        }
    }

    private fun isAnyItemExpanded(position: Int) {

        val temp = cakes.indexOfFirst {
            it.cakes_isExpandable
        }
        if (temp >= 0 && temp != position){
            cakes[temp].cakes_isExpandable = false
            notifyItemChanged(temp, 0)
        }
    }

    override fun onBindViewHolder(
        holder: CakesViewHolder,
        position: Int,
        payloads: MutableList<Any>,
    ) {

        if(payloads.isNotEmpty() && payloads[0] == 0){
            holder.collapseExpandedView()
        }else{
            super.onBindViewHolder(holder, position, payloads)
        }
    }

    fun setCakesItem(cake: List<CakesItem>){
        this.cakes = cake.toMutableList()
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = cakes.size

    inner class CakesViewHolder(val binding : CakesLayoutBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(cake: CakesItem) {
            binding.cakesTitleLayout.text = cake.cakes_name
            binding.cakesDescLayout.text = cake.cakes_desc
            binding.cakesImgLayout.setImageResource(cake.cakes_img)
        }

        fun collapseExpandedView() {
            binding.cakesDescLayout.visibility = View.GONE
        }

    }
}