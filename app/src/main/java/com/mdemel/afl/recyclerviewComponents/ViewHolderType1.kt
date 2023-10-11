package com.mdemel.afl.recyclerviewComponents

import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.mdemel.afl.R

class ViewHolderType1(itemView: View) : ViewHolder(itemView) {

    var firstTile: CardView = itemView.findViewById(R.id.firstTile)
    var secondTile: CardView = itemView.findViewById(R.id.secondTile)
    var button: AppCompatButton = itemView.findViewById(R.id.secondTile)
}