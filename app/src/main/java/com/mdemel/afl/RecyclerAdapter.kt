package com.mdemel.afl

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter

class RecyclerAdapter(val dataList: List<String>): Adapter<RecyclerItem>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerItem {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_recycler_item, parent, false)

        return RecyclerItem(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: RecyclerItem, position: Int) {
        holder.textItem.text = dataList.get(position)
    }
}