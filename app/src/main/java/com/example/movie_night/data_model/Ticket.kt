package com.example.movie_night.data_model

import java.util.UUID

data class Ticket(
    val ticketId: String,
    val qty: Int,
    val movieName: String,
    val selectedShowtime: String,
    val movieImage: String
) {
    companion object {
        fun create(
            qty: Int,
            movieName: String,
            selectedShowtime: String,
            movieImage: String
        ): Ticket {
            return Ticket(
                ticketId = UUID.randomUUID().toString(),
                qty = qty,
                movieName = movieName,
                selectedShowtime = selectedShowtime,
                movieImage = movieImage
            )
        }
    }
}

