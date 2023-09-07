package com.mdemel.afl.SecondScreen.recyclerviewComponents

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.mdemel.afl.R

class InfoScreenListItemViewHolder(itemView: View) : ViewHolder(itemView) {

    var firsttext: TextView? = null
    var secondtext: TextView? = null

    init {
        firsttext = itemView.findViewById(R.id.firstTextItem)
        secondtext = itemView.findViewById(R.id.secondTextItem)
    }
}