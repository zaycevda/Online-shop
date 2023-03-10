package com.example.onlineshopsatriaadhipradana.app.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.onlineshopsatriaadhipradana.R
import com.example.onlineshopsatriaadhipradana.app.adapters.PhotoRVAdapter.ViewHolder
import com.example.onlineshopsatriaadhipradana.databinding.ItemPhotoBinding
import com.squareup.picasso.Picasso

class PhotoRVAdapter(private val viewPager: ViewPager) : RecyclerView.Adapter<ViewHolder>() {

    var photos = mutableListOf<String>()

    inner class ViewHolder(root: View) : RecyclerView.ViewHolder(root) {

        private val binding by viewBinding(ItemPhotoBinding::bind)

        fun bind(position: Int) {

            val photo = photos[position]

//            Picasso.get().load(photo).into(binding.ivPhoto)
            Glide.with(binding.root)
                .load(photo)
                .placeholder(R.drawable.ic_loading)
                .into(binding.ivPhoto)

            itemView.setOnClickListener { viewPager.currentItem = position }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val root = inflater.inflate(R.layout.item_photo, parent, false)
        return ViewHolder(root = root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount() = photos.size
}