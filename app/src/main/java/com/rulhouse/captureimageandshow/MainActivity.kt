package com.rulhouse.captureimageandshow

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.activity.result.contract.ActivityResultContracts


class MainActivity : ComponentActivity() {

    lateinit var pictureImageView: ImageView
    lateinit var goTakePictureButton: Button
    lateinit var goToSecondButton: Button

    val TAKE_PICTURE_REQUEST_CODE = 52
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.main_activity)

        val startActivityForResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            val bitmap = it.data?.extras?.get("data") as Bitmap
            pictureImageView.setImageBitmap(bitmap)
        }

        val toSecondActivityLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {}

        pictureImageView = findViewById(R.id.picture)

        goTakePictureButton = findViewById(R.id.goTakePictureButton)
        goTakePictureButton.setOnClickListener {
            startActivityForResultLauncher.launch(Intent(MediaStore.ACTION_IMAGE_CAPTURE))
        }

        goToSecondButton = findViewById(R.id.go_to_second)
        goToSecondButton.setOnClickListener {
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            toSecondActivityLauncher.launch(intent)
        }
    }
}