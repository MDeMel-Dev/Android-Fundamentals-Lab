package com.mdemel.afl.SecondScreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.mdemel.afl.HomeScreen.dataModel.EnteredValue
import com.mdemel.afl.R
import com.mdemel.afl.SecondScreen.recyclerviewComponents.InfoScreenRecyclerAdapter

class InfoActivity : AppCompatActivity() {

    val infoRecyclerview: RecyclerView by lazy {
        findViewById(R.id.infoScreenRecyclerview)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        val valueSubmittedFromPreviousScreen = intent.getSerializableExtra("ENTERED_VALUE"   ) as? EnteredValue
        val dataList = listOf<Pair<String, String>>(Pair("Donut", valueSubmittedFromPreviousScreen!!.value),  Pair("Pizzas", valueSubmittedFromPreviousScreen!!.value), Pair("Rolls", valueSubmittedFromPreviousScreen!!.value))

         infoRecyclerview.adapter = InfoScreenRecyclerAdapter(dataList)
    }
}