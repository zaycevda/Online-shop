package com.example.onlineshopsatriaadhipradana.app.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.onlineshopsatriaadhipradana.R
import com.example.onlineshopsatriaadhipradana.app.adapters.ColorAdapter.ViewHolder
import com.example.onlineshopsatriaadhipradana.databinding.ItemColorBinding

class ColorAdapter : RecyclerView.Adapter<ViewHolder>() {

    var colors = mutableListOf<String>()

    inner class ViewHolder(root: View) : RecyclerView.ViewHolder(root) {

        private val binding by viewBinding(ItemColorBinding::bind)

        fun bind(position: Int) {

            val color = colors[position]

            binding.cvColor.setCardBackgroundColor(Color.parseColor(color))

            if (color != "#FAF9FF")
                binding.cvColor.strokeColor = Color.TRANSPARENT
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val root = inflater.inflate(R.layout.item_color, parent, false)
        return ViewHolder(root = root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position = position)
    }

    override fun getItemCount() = colors.size
}