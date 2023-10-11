package com.mdemel.afl.recyclerviewComponents

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.mdemel.afl.R
import com.mdemel.afl.models.ListItem

class MyRecyclerviewAdapter(val context: Context, val dataList: List<ListItem>): Adapter<com.mdemel.afl.recyclerviewComponents.ListItem>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): com.mdemel.afl.recyclerviewComponents.ListItem {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_viewholder, parent, false)

        return ListItem(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(listItem: com.mdemel.afl.recyclerviewComponents.ListItem, position: Int) {
        dataList.get(position).let { data ->
            listItem.firstTileText.text = data.firstTile
            listItem.secondTileText.text = data.secondTile
            listItem.button.text = data.button
        }
    }
}