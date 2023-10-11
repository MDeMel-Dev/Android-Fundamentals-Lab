package com.mdemel.afl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Add first ever fragment to Activity
        supportFragmentManager.commit {
            add(R.id.fragment_container_view, HomeScreenFragment::class.java, null)
            setReorderingAllowed(true)
            addToBackStack("home") // Name can be null
        }
    }
}