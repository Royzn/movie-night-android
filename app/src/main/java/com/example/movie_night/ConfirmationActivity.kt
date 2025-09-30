package com.example.movie_night

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.bumptech.glide.Glide
import com.example.movie_night.service.TicketService

class ConfirmationActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.confirmation_screen)

        val quantity = findViewById<EditText>(R.id.editTextQuantity)
        val movieTitle = findViewById<TextView>(R.id.movieTitle)
        val movieShowtime = findViewById<TextView>(R.id.selectedShowtime)
        val confirmBtn = findViewById<Button>(R.id.buttonConfirm)
        val cancelBtn = findViewById<Button>(R.id.buttonCancel)
        val movieImage = findViewById<ImageView>(R.id.imageView)

        movieTitle.text = intent.getStringExtra("MOVIE_NAME")
        val movieShowTimeIntent = intent.getStringExtra("MOVIE_SHOWTIME")
        val showtimeText = "Showtime: ${intent.getStringExtra("MOVIE_SHOWTIME")}"
        val movieImageUrl = intent.getStringExtra("MOVIE_URL")
        movieShowtime.text = showtimeText

        Glide.with(this)
            .load(movieImageUrl) // load URL from intent
            .placeholder(android.R.drawable.ic_menu_report_image) // placeholder image while loading
            .error(android.R.drawable.stat_notify_error) // image to show on error
            .into(movieImage)

        confirmBtn.setOnClickListener {
            val realQuantity = quantity.text.toString().toIntOrNull() ?: 0

            if(realQuantity == 0) Toast.makeText(this, "Quantity must be filled", Toast.LENGTH_SHORT).show()
            else{
                TicketService.addTicket(realQuantity, movieTitle.text.toString(), movieImageUrl.toString(), movieShowTimeIntent.toString())
                finish()
            }
        }

        cancelBtn.setOnClickListener {
            finish()
        }
    }
}