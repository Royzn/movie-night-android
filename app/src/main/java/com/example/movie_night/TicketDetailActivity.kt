package com.example.movie_night

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.bumptech.glide.Glide

class TicketDetailActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ticket_detail)

        // Get views
        val movieTitle = findViewById<TextView>(R.id.movieTitle)
        val imageView = findViewById<ImageView>(R.id.imageView)
        val selectedShowtime = findViewById<TextView>(R.id.selectedShowtime)
        val textQuantity = findViewById<TextView>(R.id.textQuantity)
        val buttonBack = findViewById<Button>(R.id.buttonBack)
        val ticketIdView = findViewById<TextView>(R.id.ticketId)

        // Get extras
        val ticketId = intent.getStringExtra("EXTRA_TICKET_ID") ?: ""
        val movieName = intent.getStringExtra("EXTRA_MOVIE_NAME") ?: ""
        val showtime = intent.getStringExtra("EXTRA_SHOWTIME") ?: ""
        val quantity = intent.getIntExtra("EXTRA_QUANTITY", 0)
        val movieImage = intent.getStringExtra("EXTRA_MOVIE_IMAGE") ?: ""

        // Bind data to views
        movieTitle.text = movieName
        selectedShowtime.text = "Showtime: $showtime"
        textQuantity.text = "Quantity: $quantity"
        ticketIdView.text = "Ticket ID: $ticketId"

        Glide.with(this)
            .load(movieImage)
            .placeholder(android.R.drawable.ic_menu_report_image) // or your placeholder
            .into(imageView)

        // Back button handler
        buttonBack.setOnClickListener {
            finish()
        }
    }
}
