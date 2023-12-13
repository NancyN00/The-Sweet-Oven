package com.example.thesweetoven.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.thesweetoven.R
import com.example.thesweetoven.dataclasses.DiscoverItem
import com.example.thesweetoven.databinding.DiscoverLayoutBinding
import com.example.thesweetoven.fragments.SearchFragment

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

      //  holder.itemView.setOnClickListener (object: View.OnClickListener{
        //    override fun onClick(p0: View?) {
        //        val activity=p0!!.context as AppCompatActivity
             //   val searchFrag = SearchFragment()
              //  activity.supportFragmentManager.beginTransaction().replace(R.id.recho, searchFrag).addToBackStack(null).commit()
         //   }
     //   })


    }
    override fun getItemCount() : Int = discovers.size

    //this method is used to set the list from the viewholder
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



