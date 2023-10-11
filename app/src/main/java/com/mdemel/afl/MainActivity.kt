package com.mdemel.afl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.mdemel.afl.models.ListItemDataModel
import com.mdemel.afl.recyclerviewComponents.MyRecyclerviewAdapter

class MainActivity : AppCompatActivity() {

    private val recyclerView: RecyclerView by lazy {
        findViewById(R.id.homeScreenRecyclerView)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.adapter = MyRecyclerviewAdapter(
            context = this,
            dataList = listOf(
                ListItemDataModel("Iron Man", "War Machine", "I am Iron Man"),
                ListItemDataModel("Captain America", "Bucky Barnes", "I can do this all day"),
                ListItemDataModel("Thor", "Loki", "I am the God of Thunder"),
                ListItemDataModel("Spider-Man", "Venom", "With great power comes great responsibility"),
                ListItemDataModel("Black Widow", "Hawkeye", "I'm always picking up after you boys"),
                ListItemDataModel("Hulk", "She-Hulk", "Hulk smash!"),
                ListItemDataModel("Doctor Strange", "Wong", "I've come to bargain"),
                ListItemDataModel("Black Panther", "Shuri", "Wakanda forever!"),
                ListItemDataModel("Ant-Man", "The Wasp", "Hi, I'm Scott"),
                ListItemDataModel("Scarlet Witch", "Quicksilver", "No more mutants"),
                ListItemDataModel("Deadpool", "Cable", "Chimichangas!"),
                ListItemDataModel("Wolverine", "X-23", "I'm the best there is at what I do"),
                ListItemDataModel("Captain Marvel", "Ms. Marvel", "Higher, further, faster"),
                ListItemDataModel("Doctor Doom", "Doctor Doom II", "I am Doom!"),
                ListItemDataModel("Magneto", "Quicksilver", "Everything they've built will fall!"),
                ListItemDataModel("Thanos", "Gamora", "Dread it. Run from it. Destiny still arrives.")
            )
        )
    }
}