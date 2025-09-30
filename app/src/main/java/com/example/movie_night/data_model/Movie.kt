package com.example.movie_night.data_model

data class Movie(
    val name: String,
    val imageUrl: String,
    val showtimes: List<String>
)