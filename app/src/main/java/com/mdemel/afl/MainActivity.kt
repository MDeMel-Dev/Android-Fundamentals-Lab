package com.mdemel.afl

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.core.widget.addTextChangedListener
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private var button: AppCompatButton? = null
    private var inputTextField: TextInputEditText? = null

    private var insertedText = ""

    private val intentToNavigateToSecondScreen by lazy {
        Intent(this, SecondScreenActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.buttonHomeScreen) as? AppCompatButton
        inputTextField = findViewById(R.id.inputField) as? TextInputEditText

        button?.setOnClickListener {
            Log.d("MelbClass", "Button clicked ")
            Toast.makeText(this, "User inserted: $insertedText", Toast.LENGTH_LONG).show()

            // Syntax for adding data into Intent
            intentToNavigateToSecondScreen.putExtra("key1", insertedText)

            startActivity(intentToNavigateToSecondScreen)
        }

        inputTextField?.addTextChangedListener { textValue ->
            insertedText = textValue.toString()
        }
    }
}