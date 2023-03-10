package com.example.onlineshopsatriaadhipradana.app.presentation.profile

import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.onlineshopsatriaadhipradana.R
import com.example.onlineshopsatriaadhipradana.app.storage.SharedPreferences
import com.example.onlineshopsatriaadhipradana.app.presentation.activity.RegisterActivity
import com.example.onlineshopsatriaadhipradana.databinding.FragmentProfileBinding

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private val binding by viewBinding(FragmentProfileBinding::bind)

    private val sharedPreferences by lazy { SharedPreferences(requireActivity()) }

    private lateinit var takePhoto: ActivityResultLauncher<String>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogOut.setOnClickListener { sharedPreferences.logOut(RegisterActivity()) }

        binding.tbProfile.setNavigationOnClickListener { findNavController().popBackStack() }

        changePhoto()
    }

    private fun changePhoto() {
        takePhoto = registerForActivityResult(ActivityResultContracts.GetContent()) {
            if (it == null)
                binding.ivAvatar.setImageResource(R.drawable.satria_adhi_pradana)
            else
                binding.ivAvatar.setImageURI(it)
        }
        binding.tvChangeAvatar.setOnClickListener { takePhoto.launch("image/*") }
    }
}