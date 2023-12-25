package com.example.thesweetoven.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.thesweetoven.databinding.CakesLayoutBinding
import com.example.thesweetoven.databinding.CupcakesLayoutBinding
import com.example.thesweetoven.dataclasses.CupcakesItem
import com.example.thesweetoven.dataclasses.DonutsItem

class CupcakesAdapter : RecyclerView.Adapter<CupcakesAdapter.CupcakeViewHolder>() {

    private var cupcakes = mutableListOf<CupcakesItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CupcakeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CupcakesLayoutBinding.inflate(inflater, parent, false)
        return  CupcakeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CupcakeViewHolder, position: Int) {
        val cupca = cupcakes[position]
        holder.bind(cupca)

        val isExpandable : Boolean = cupca.cupcakes_isExpandable
        holder.binding.cupcakeDescLayout.visibility = if(isExpandable) View.VISIBLE else View.GONE

        holder.binding.constraintCupcakeLayout.setOnClickListener {
            isAnyItemExpanded(position)
            cupca.cupcakes_isExpandable = !cupca.cupcakes_isExpandable
            notifyItemChanged(position, Unit)
        }
    }

    private fun isAnyItemExpanded(position: Int) {
        val temp = cupcakes.indexOfFirst {
            it.cupcakes_isExpandable
        }
        if (temp >= 0 && temp != position){
            cupcakes[temp].cupcakes_isExpandable = false
            notifyItemChanged(temp, 0)
        }
    }

    override fun onBindViewHolder(
        holder: CupcakeViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        if(payloads.isNotEmpty() && payloads[0] == 0){
            holder.collapseExpandedView()
        }else{
            super.onBindViewHolder(holder, position, payloads)
        }
    }

    fun setCupcakesItem(cupke : List<CupcakesItem>){
        this.cupcakes = cupke.toMutableList()
        notifyDataSetChanged()

    }
    override fun getItemCount(): Int = cupcakes.size

    inner class CupcakeViewHolder(val binding: CupcakesLayoutBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(cupcak: CupcakesItem) {
            binding.cupcakeTitleLayout.text = cupcak.cupcakes_name
            binding.cupcakeDescLayout.text = cupcak.cupcakes_desc
            binding.cupcakeImgLayout.setImageResource(cupcak.cupcakes_img)
        }

        fun collapseExpandedView() {
            binding.cupcakeDescLayout.visibility = View.GONE
        }

    }
}