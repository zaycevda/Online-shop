package com.example.onlineshopsatriaadhipradana.app.utils

import androidx.viewpager.widget.ViewPager

class MyOnPageClickListener(private val onSuccess: (Int) -> Unit): ViewPager.OnPageChangeListener {

    override fun onPageSelected(position: Int) { onSuccess(position) }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
    override fun onPageScrollStateChanged(state: Int) {}
}