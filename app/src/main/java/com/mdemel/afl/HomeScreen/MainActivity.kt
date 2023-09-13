package com.mdemel.afl.HomeScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import com.mdemel.afl.R
import com.mdemel.afl.SecondScreen.InfoActivity

class MainActivity : AppCompatActivity() {
    lateinit private var submitButton: Button
    lateinit private var usernameCollectionForm: EditText
    lateinit private var passwordCollectionForm: EditText

    var textHolder = ""

    val viewModel: HomeScreenViewModel by lazy {
        ViewModelProvider(this).get(HomeScreenViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intentToNavigateToInfoScreen = Intent(this, InfoActivity::class.java)

        // Get references to the views in our layout file
        submitButton = findViewById(R.id.navigateButtonToInfo)
        usernameCollectionForm = findViewById(R.id.usernameCollectForm)
        passwordCollectionForm = findViewById(R.id.passwordCollectForm)

        // set click listners/callbacks
        submitButton.setOnClickListener {
            viewModel.submitClicked.value = true
        }

        usernameCollectionForm.addTextChangedListener {
            viewModel.usernameValue = it.toString()
        }

        passwordCollectionForm.addTextChangedListener {
            viewModel.passwordValue = it.toString()
        }


        viewModel.submitClicked?.observe(this) {
            if (it != false) {
                viewModel.makeUserAuthenticationCall()
            }
        }

        viewModel.authenticated?.observe(this) {
            if (it.isNotEmpty()) {
                Toast.makeText(this , "result: $it", Toast.LENGTH_LONG).show()
            }
        }
    }
}