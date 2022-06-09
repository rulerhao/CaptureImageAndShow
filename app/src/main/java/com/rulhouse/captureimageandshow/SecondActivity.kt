package com.rulhouse.captureimageandshow

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import androidx.activity.ComponentActivity

class SecondActivity : ComponentActivity() {

    lateinit var backToFirstButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.second_activity)
        backToFirstButton = findViewById(R.id.return_to_main)
        backToFirstButton.setOnClickListener {
            finish()
        }
    }
}