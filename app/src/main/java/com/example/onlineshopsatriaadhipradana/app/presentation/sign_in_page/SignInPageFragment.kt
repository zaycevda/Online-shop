package com.example.onlineshopsatriaadhipradana.app.presentation.sign_in_page

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.onlineshopsatriaadhipradana.R
import com.example.onlineshopsatriaadhipradana.app.App
import com.example.onlineshopsatriaadhipradana.app.presentation.activity.MainActivity
import com.example.onlineshopsatriaadhipradana.app.storage.SharedPreferences
import com.example.onlineshopsatriaadhipradana.databinding.FragmentSignInPageBinding
import com.example.onlineshopsatriaadhipradana.app.utils.isEmailValid
import com.example.onlineshopsatriaadhipradana.app.utils.showToast
import javax.inject.Inject

class SignInPageFragment : Fragment(R.layout.fragment_sign_in_page) {

    @Inject
    lateinit var signInPageViewModelFactory: SignInPageViewModelFactory

    private val binding by viewBinding(FragmentSignInPageBinding::bind)

    private val viewModel by lazy {
        ViewModelProvider(this, signInPageViewModelFactory)[SignInPageViewModel::class.java]
    }

    private val sharedPreferences by lazy { SharedPreferences(requireActivity()) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        inject()

        sharedPreferences.checkAuth(MainActivity())

        binding.tvLogIn.setOnClickListener {
            findNavController().navigate(R.id.action_signInPageFragment_to_loginFragment)
        }

        binding.btnSignIn.setOnClickListener { checkIsEmailValid() }
    }

    private fun inject() {
        (activity?.applicationContext as App).appComponent.injectSignInPageFragment(
            signInPageFragment = this
        )
    }

    private fun checkIsEmailValid() {
        if (binding.etEmail.isEmailValid())
            registration()
        else
            showToast(message = "Электронная почта введена неверно")
    }

    private fun registration() {

        viewModel.exist(
            email = binding.etEmail.text.toString(),
            firstName = binding.etFirstName.text.toString()
        )

        viewModel.alreadyExist.observe(viewLifecycleOwner) {
            if (it)
                showToast(message = "Введенные данные для регистрации заняты")
            else {
                viewModel.createAccount(
                    email = binding.etEmail.text.toString(),
                    firstName = binding.etFirstName.text.toString(),
                    lastName = binding.etLastName.text.toString()
                )
                sharedPreferences.logIn(appCompatActivity = MainActivity())
            }
        }
    }
}