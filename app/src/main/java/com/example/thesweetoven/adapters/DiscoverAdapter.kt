package com.example.thesweetoven.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.example.thesweetoven.R
import com.example.thesweetoven.databinding.DiscoverLayoutBinding
import com.example.thesweetoven.dataclasses.DiscoverItem

class DiscoverAdapter(
    val onItemClick:(discover: DiscoverItem)-> Unit )
   // private val navController: NavController,
 : RecyclerView.Adapter<DiscoverAdapter.DiscoverViewHolder>() {

    private var discovers = mutableListOf<DiscoverItem>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiscoverViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DiscoverLayoutBinding.inflate(inflater, parent, false)
        return DiscoverViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DiscoverViewHolder, position: Int) {
        val discover = discovers[position]
        holder.bind(discover)

     holder.itemView.setOnClickListener {
           onItemClick(discover)
     }

/*        holder.itemView.setOnClickListener {
            navController.navigate(R.id.action_homeFragment_to_searchFragment)
        }*/
    }

    override fun getItemCount(): Int = discovers.size

    //this method is used to set the list from the viewholder
    fun setDiscoverItems(discover: List<DiscoverItem>) {
        this.discovers = discover.toMutableList()
        notifyDataSetChanged()
    }

    inner class DiscoverViewHolder(private val binding: DiscoverLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: DiscoverItem) {
            binding.txtExplore.text = item.title
            binding.imgExplore.setImageResource(item.img)

        }
    }
}



