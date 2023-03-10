package com.example.onlineshopsatriaadhipradana.app.utils

import android.app.Activity
import android.content.Intent
import android.util.Patterns
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

fun Activity.replaceActivity(activity: AppCompatActivity) {
    val intent = Intent(this, activity::class.java)
    startActivity(intent)
    this.finish()
}

fun Fragment.showToast(message: String) {
    Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
}

fun EditText.isEmailValid() =
    Patterns.EMAIL_ADDRESS.matcher(this.text.toString()).matches()