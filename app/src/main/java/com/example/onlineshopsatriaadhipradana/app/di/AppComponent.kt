package com.example.onlineshopsatriaadhipradana.app.di

import com.example.onlineshopsatriaadhipradana.app.presentation.login.LoginFragment
import com.example.onlineshopsatriaadhipradana.app.presentation.page_1.Page1Fragment
import com.example.onlineshopsatriaadhipradana.app.presentation.page_2.Page2Fragment
import com.example.onlineshopsatriaadhipradana.app.presentation.sign_in_page.SignInPageFragment
import dagger.Component

@Component(modules = [AppModule::class, DataModule::class, DomainModule::class])
interface AppComponent {

    fun injectSignInPageFragment(signInPageFragment: SignInPageFragment)

    fun injectPage1Fragment(page1Fragment: Page1Fragment)

    fun injectLoginFragment(loginFragment: LoginFragment)

    fun injectPage2Fragment(page2Fragment: Page2Fragment)
}