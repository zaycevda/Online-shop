package com.example.onlineshopsatriaadhipradana.app.adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.example.onlineshopsatriaadhipradana.R
import com.squareup.picasso.Picasso

class PhotoVPAdapter(
    private val context: Context
//    private val imageUrls: List<String>
) : PagerAdapter() {

    var imageUrls = mutableListOf<String>()

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val imageView = ImageView(context)
//        Picasso.get().load(imageUrls[position]).into(imageView)
        Glide.with(context)
            .load(imageUrls[position])
            .placeholder(R.drawable.ic_loading)
            .into(imageView)
        container.addView(imageView)
        return imageView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun getCount() = imageUrls.size

    override fun isViewFromObject(view: View, `object`: Any) = view == `object`
}