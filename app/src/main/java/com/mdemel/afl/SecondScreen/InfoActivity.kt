package com.mdemel.afl.SecondScreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.mdemel.afl.R

class InfoActivity : AppCompatActivity() {

    val infoRecyclerview: RecyclerView by lazy {
        findViewById(R.id.infoScreenRecyclerview)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
    }
}