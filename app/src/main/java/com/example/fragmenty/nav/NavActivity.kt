package com.example.fragmenty.nav

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fragmenty.R

class NavActivity : AppCompatActivity(), ButtonClicker {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nav_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.container, Nav1Fragment.newInstance())
                .commitNow()
        }

    }

    override fun buttonClicked() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, Nav2Fragment.newInstance())
            .commitNow()
    }

    override fun button2Clicked() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, Nav1Fragment.newInstance())
            .commitNow()
    }
}
