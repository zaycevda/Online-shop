package com.example.onlineshopsatriaadhipradana.app.presentation.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.onlineshopsatriaadhipradana.R
import com.example.onlineshopsatriaadhipradana.app.App
import com.example.onlineshopsatriaadhipradana.app.presentation.activity.MainActivity
import com.example.onlineshopsatriaadhipradana.app.storage.SharedPreferences
import com.example.onlineshopsatriaadhipradana.app.utils.showToast
import com.example.onlineshopsatriaadhipradana.databinding.FragmentLoginBinding
import javax.inject.Inject

class LoginFragment : Fragment(R.layout.fragment_login) {

    @Inject
    lateinit var loginViewModelFactory: LoginViewModelFactory

    private val binding by viewBinding(FragmentLoginBinding::bind)

    private val viewModel by lazy {
        ViewModelProvider(this, loginViewModelFactory)[LoginViewModel::class.java]
    }

    private val sharedPreferences by lazy { SharedPreferences(requireActivity()) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        inject()

        binding.btnSignIn.setOnClickListener { login() }
    }

    private fun inject() {
        (activity?.applicationContext as App).appComponent.injectLoginFragment(loginFragment = this)
    }

    private fun login() {
        viewModel.alreadyExist.observe(viewLifecycleOwner) {
            if (it)
                sharedPreferences.logIn(appCompatActivity = MainActivity())
            else
                showToast(message = "Аккаунт не существует")
        }
        viewModel.exist(firstName = binding.etFirstName.text.toString())
    }
}