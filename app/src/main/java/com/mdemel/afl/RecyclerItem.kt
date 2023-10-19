package com.mdemel.afl

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerItem(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val textItem = itemView.findViewById<TextView>(R.id.text_Item)
}