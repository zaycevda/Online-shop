package com.example.onlineshopsatriaadhipradana.app.presentation.page_2

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.data.utils.showLog
import com.example.onlineshopsatriaadhipradana.R
import com.example.onlineshopsatriaadhipradana.app.App
import com.example.onlineshopsatriaadhipradana.app.adapters.ColorAdapter
import com.example.onlineshopsatriaadhipradana.app.adapters.PhotoRVAdapter
import com.example.onlineshopsatriaadhipradana.app.adapters.PhotoVPAdapter
import com.example.onlineshopsatriaadhipradana.databinding.FragmentPage2Binding
import com.example.onlineshopsatriaadhipradana.app.utils.MyOnPageClickListener
import javax.inject.Inject

class Page2Fragment : Fragment(R.layout.fragment_page2) {

    @Inject
    lateinit var page2ViewModelFactory: Page2ViewModelFactory

    private val binding by viewBinding(FragmentPage2Binding::bind)

    private val viewModel by lazy {
        ViewModelProvider(this, page2ViewModelFactory)[Page2ViewModel::class.java]
    }

    private val photoVPAdapter by lazy {
        PhotoVPAdapter(requireContext())
    }

    private val photoRVAdapter by lazy { PhotoRVAdapter(binding.vpPhotos) }

    private val colorAdapter by lazy { ColorAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        inject()

        binding.tbPage2.setNavigationOnClickListener { findNavController().popBackStack() }

        initAdapters()

        getDetails()

        onPageClickListener()


        binding.btnMinus.setOnClickListener { minus() }

        binding.btnPlus.setOnClickListener { plus() }
    }

    private fun minus() {
        viewModel.details.observe(viewLifecycleOwner) {
            if (binding.tvCount.text.toString().toInt() > 0) {
                binding.tvResultPrice.text =
                    "${binding.tvResultPrice.text.toString().toFloat() - it?.price?.toFloat()!!}"
                binding.tvCount.text = "${binding.tvCount.text.toString().toInt() - 1}"
            }
        }
    }

    private fun plus() {
        viewModel.details.observe(viewLifecycleOwner) {
            if (binding.tvResultPrice.text.toString().isNotEmpty())
                binding.tvResultPrice.text =
                    "${binding.tvResultPrice.text.toString().toFloat() + it?.price?.toFloat()!!}"
            else
                binding.tvResultPrice.text = it?.price.toString()
            binding.tvCount.text = "${binding.tvCount.text.toString().toInt() + 1}"
        }
    }

    private fun inject() {
        (activity?.applicationContext as App).appComponent.injectPage2Fragment(page2Fragment = this)
    }

    private fun initAdapters() {
        binding.rvColors.adapter = colorAdapter
        binding.rvPhoto.adapter = photoRVAdapter
        binding.vpPhotos.adapter = photoVPAdapter
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun getDetails() {
        viewModel.details.observe(viewLifecycleOwner) {
            if (it != null) {
                binding.tvName.text = it.name
                binding.tvDescription.text = it.description
                binding.tvRating.text = it.rating
                binding.tvNumberOfReviews.text = "(${it.numberOfReviews} reviews)"
                binding.tvPrice.text = "$ ${it.price}"

                colorAdapter.colors = it.colors.toMutableList()
                colorAdapter.notifyDataSetChanged()

                photoVPAdapter.imageUrls = it.imageUrls.toMutableList()
                photoVPAdapter.notifyDataSetChanged()

                photoRVAdapter.photos = it.imageUrls.toMutableList()
                photoRVAdapter.notifyDataSetChanged()

            }
        }
        viewModel.getDetails()
    }

    private fun onPageClickListener() {
        binding.vpPhotos.addOnPageChangeListener(MyOnPageClickListener {
            binding.rvPhoto.smoothScrollToPosition(it)
        })
    }
}