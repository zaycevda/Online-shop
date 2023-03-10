package com.example.onlineshopsatriaadhipradana.app.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.onlineshopsatriaadhipradana.R
import com.example.data.retrofit.model.LatestModel
import com.example.onlineshopsatriaadhipradana.databinding.ItemLatestBinding

class LatestAdapter : RecyclerView.Adapter<LatestAdapter.ViewHolder>() {

    var latestList = mutableListOf<LatestModel>()

    inner class ViewHolder(root: View) : RecyclerView.ViewHolder(root) {

        private val binding by viewBinding(ItemLatestBinding::bind)

        fun bind(position: Int) {

            val latest = latestList[position]

//            Picasso.get().load(latest.imageUrl).into(binding.ivProduct)
            Glide.with(binding.root)
                .load(latest.imageUrl)
                .placeholder(R.drawable.ic_loading)
                .into(binding.ivProduct)
            binding.tvName.text = latest.name
            binding.tvCategory.text = latest.category
            binding.tvPrice.text = "$ ${latest.price}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val root = inflater.inflate(R.layout.item_latest, parent, false)
        return ViewHolder(root = root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position = position)
    }

    override fun getItemCount() = latestList.size
}