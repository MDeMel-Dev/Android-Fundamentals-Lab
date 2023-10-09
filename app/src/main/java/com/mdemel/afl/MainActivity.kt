package com.mdemel.afl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    private var shapesImageView: ImageView? = null
    private var changeShapeButton: Button? = null
    private val listOfShapeDrawables =
        listOf(R.drawable.img_cube, R.drawable.img_pyramid, R.drawable.img_sphere)
    private var currentShape: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        shapesImageView = findViewById(R.id.imageViewShapes) as? ImageView
        changeShapeButton = findViewById(R.id.buttonChangeShape) as? Button

        changeShapeButton?.setOnClickListener {
            currentShape = swapShape()
            currentShape?.let { shape ->
                shapesImageView?.setImageResource(shape);
            }
        }

        Log.d("MelbAPPDemo", "onCreate: called")
    }

    override fun onStart() {
        super.onStart()

        Log.d("MelbAPPDemo", "onStart: ")
    }

    override fun onResume() {
        super.onResume()

        Log.d("MelbAPPDemo", "onResume: called")
    }

    override fun onPause() {
        super.onPause()

        Log.d("MelbAPPDemo", "onPause: was called")
    }

    override fun onStop() {
        super.onStop()

        Log.d("MelbAPPDemo", "onStop: was called")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d("MelbAPPDemo", "onDestroy: called")
    }


    fun swapShape(): Int {
        return listOfShapeDrawables.filterNot { it.equals(currentShape) }.random()
    }
}