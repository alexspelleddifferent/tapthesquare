package com.example.seekbarportraitlandscape

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

const val EXTRA_TAPPED_INSIDE_SQUARE = "com.example.seekbarportraitlandscape.TAPPED_INSIDE_SQUARE"
class SquareActivity : AppCompatActivity() {

    private lateinit var squareImage:ImageView
    private lateinit var container: View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_square)

        squareImage = findViewById(R.id.square)
        container = findViewById(R.id.container)

        var squareSize = intent.getIntExtra(EXTRA_SQUARE_SIZE, 100)
        if (squareSize == 0) {
            squareSize = 1
        }
        squareImage.layoutParams.height = squareSize
        squareImage.layoutParams.width = squareSize

        squareImage.setOnClickListener {
            squareTapped(true)
        }

        container.setOnClickListener {
            squareTapped(false)
        }
    }

    private fun squareTapped(didTapSquare: Boolean) {
        val resultIntent = Intent ()
        resultIntent.putExtra(EXTRA_TAPPED_INSIDE_SQUARE, didTapSquare)
        setResult(RESULT_OK, resultIntent)
        finish()
    }
}