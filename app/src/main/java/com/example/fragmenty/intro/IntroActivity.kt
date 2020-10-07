package com.example.fragmenty.intro

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fragmenty.R

class IntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.intro_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, IntroFragment.newInstance())
                .commitNow()
        }

    }
}
