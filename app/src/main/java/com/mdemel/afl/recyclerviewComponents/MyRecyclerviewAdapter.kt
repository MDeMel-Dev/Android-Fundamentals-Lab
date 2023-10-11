package com.mdemel.afl.recyclerviewComponents

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.mdemel.afl.models.ListItem

class MyRecyclerviewAdapter(val context: Context, val dataList: List<ListItem>): Adapter<ViewHolderType1>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderType1 {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolderType1, position: Int) {
        TODO("Not yet implemented")
    }
}