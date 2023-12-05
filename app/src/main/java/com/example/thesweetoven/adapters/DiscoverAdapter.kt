package com.example.thesweetoven.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.thesweetoven.data.DiscoverItem
import com.example.thesweetoven.databinding.DiscoverLayoutBinding

class DiscoverAdapter : RecyclerView.Adapter<DiscoverAdapter.DiscoverViewHolder>() {

    private var discovers = mutableListOf<DiscoverItem>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiscoverViewHolder {
         val inflater = LayoutInflater.from(parent.context)
         val binding = DiscoverLayoutBinding.inflate(inflater, parent, false)
        return DiscoverViewHolder(binding)
    }
    override fun onBindViewHolder(holder: DiscoverViewHolder, position: Int) {
           val discover = discovers[position]
        holder.bind(discover)
    }
    override fun getItemCount() : Int = discovers.size

    fun setDiscoverItems(discover : List<DiscoverItem>){
        this.discovers = discover.toMutableList()
        notifyDataSetChanged()
    }

    inner class DiscoverViewHolder(private val binding : DiscoverLayoutBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(item: DiscoverItem){
            binding.txtExplore.text = item.title
            binding.imgExplore.setImageResource(item.img)
        }
    }
}


