package com.example.onlineshopsatriaadhipradana.app.presentation.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.onlineshopsatriaadhipradana.R
import com.example.onlineshopsatriaadhipradana.databinding.ItemCarouselViewBinding

class CarouselItemView(
    context: Context,
    attrs: AttributeSet?,
    defStyleAttr: Int,
    defStyleRes: Int
) : RelativeLayout(context, attrs, defStyleAttr, defStyleRes) {

    private val binding by viewBinding(ItemCarouselViewBinding::bind)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : this(context, attrs, defStyleAttr, 0)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0, 0)
    constructor(context: Context) : this(context, null, 0, 0)

    init {
        val inflater = LayoutInflater.from(context)
        inflater.inflate(R.layout.item_carousel_view, this, true)
        initAttrs(attrs, defStyleAttr, defStyleRes)
    }

    private fun initAttrs(attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) {
        if (attrs == null) return

        val typedArray = context.obtainStyledAttributes(
            attrs,
            R.styleable.CarouselItemView,
            defStyleAttr,
            defStyleRes
        )

        val image = typedArray.getDrawable(R.styleable.CarouselItemView_image)
        binding.image.setImageDrawable(image)

        val title = typedArray.getString(R.styleable.CarouselItemView_title)
        binding.title.text = title

        typedArray.recycle()
    }
}