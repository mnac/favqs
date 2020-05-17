package com.android.favqs.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.favqs.R
import com.android.favqs.ui.main.login.LoginFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
    }
}
