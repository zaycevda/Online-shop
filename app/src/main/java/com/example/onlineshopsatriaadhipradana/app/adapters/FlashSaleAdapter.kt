package com.example.onlineshopsatriaadhipradana.app.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.onlineshopsatriaadhipradana.R
import com.example.onlineshopsatriaadhipradana.app.adapters.FlashSaleAdapter.ViewHolder
import com.example.data.retrofit.model.FlashSaleModel
import com.example.onlineshopsatriaadhipradana.databinding.ItemFlashSaleBinding
import com.squareup.picasso.Picasso

class FlashSaleAdapter : RecyclerView.Adapter<ViewHolder>() {

    private lateinit var listener: OnItemClickListener

    var flashSaleList = mutableListOf<FlashSaleModel>()

    inner class ViewHolder(root: View) : RecyclerView.ViewHolder(root) {

        private val binding by viewBinding(ItemFlashSaleBinding::bind)

        fun bind(position: Int) {

            val flashSale = flashSaleList[position]

//            Picasso.get().load(flashSale.imageUrl).into(binding.ivProduct)
            Glide.with(binding.root)
                .load(flashSale.imageUrl)
                .placeholder(R.drawable.ic_loading)
                .into(binding.ivProduct)
            binding.tvCategory.text = flashSale.category
            binding.tvName.text = flashSale.name
            binding.tvPrice.text = "$ ${flashSale.price}"
            binding.tvDiscount.text = "${flashSale.discount}% off"

            if (position == 1)
                itemView.setOnClickListener { listener.onClicked() }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val root = inflater.inflate(R.layout.item_flash_sale, parent, false)
        return ViewHolder(root = root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position = position)
    }

    override fun getItemCount() = flashSaleList.size

    interface OnItemClickListener {
        fun onClicked()
    }

    fun setOnClickListener(onItemClickListener: OnItemClickListener) {
        listener = onItemClickListener
    }
}