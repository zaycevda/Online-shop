package com.example.onlineshopsatriaadhipradana.app.presentation.page_1

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.view.View
import android.widget.ArrayAdapter
import androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.data.utils.showLog
import com.example.onlineshopsatriaadhipradana.R
import com.example.onlineshopsatriaadhipradana.app.App
import com.example.onlineshopsatriaadhipradana.app.adapters.FlashSaleAdapter
import com.example.onlineshopsatriaadhipradana.app.adapters.FlashSaleAdapter.OnItemClickListener
import com.example.onlineshopsatriaadhipradana.app.adapters.LatestAdapter
import com.example.onlineshopsatriaadhipradana.app.utils.showToast
import com.example.onlineshopsatriaadhipradana.databinding.FragmentPage1Binding
import java.util.*
import javax.inject.Inject

class Page1Fragment : Fragment(R.layout.fragment_page1) {

    @Inject
    lateinit var page1ViewModelFactory: Page1ViewModelFactory

    private val binding by viewBinding(FragmentPage1Binding::bind)

    private val viewModel by lazy {
        ViewModelProvider(this, page1ViewModelFactory)[Page1ViewModel::class.java]
    }

    private val latestAdapter by lazy { LatestAdapter() }

    private val flashSaleAdapter by lazy { FlashSaleAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        inject()

        initNavigation()

        setSpan()

        initRV()

        getWords()

        getAllLatest()

        getAllFlashSale()
    }

    private fun inject() {
        (activity?.applicationContext as App).appComponent.injectPage1Fragment(page1Fragment = this)
    }

    private fun initNavigation() {
        val onClicked = object : OnItemClickListener {
            override fun onClicked() {
                findNavController().navigate(R.id.action_page1Fragment_to_page2Fragment)
            }
        }
        flashSaleAdapter.setOnClickListener(onItemClickListener = onClicked)
    }

    private fun setSpan() {
        val spanText = SpannableString(resources.getString(R.string.trade_by_bata))
        spanText.setSpan(
            ForegroundColorSpan(resources.getColor(R.color.purple_500, context?.theme)),
            START_SPAN,
            spanText.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        binding.tvTitle.text = spanText
    }

    private fun initRV() {
        binding.rvLatest.adapter = latestAdapter
        binding.rvFlashSale.adapter = flashSaleAdapter
    }

    private fun getWords() {
        viewModel.words.observe(viewLifecycleOwner) {
            val adapter =
                ArrayAdapter(requireContext(), support_simple_spinner_dropdown_item, it)
            binding.etSearch.setAdapter(adapter)
            binding.etSearch.threshold = 1
        }
        viewModel.getWords()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun getAllLatest() {
        viewModel.latest.observe(viewLifecycleOwner) {
            if (it != null) {
                latestAdapter.latestList = it.toMutableList()
            }
            latestAdapter.notifyDataSetChanged()
        }
        viewModel.getAllLatest()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun getAllFlashSale() {
        viewModel.flashSale.observe(viewLifecycleOwner) {
            flashSaleAdapter.flashSaleList = it.toMutableList()
            flashSaleAdapter.notifyDataSetChanged()
        }
        viewModel.getAllFlashSale()
    }

    private companion object {
        private const val START_SPAN = 8
    }
}