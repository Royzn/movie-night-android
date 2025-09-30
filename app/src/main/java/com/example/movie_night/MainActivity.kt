package com.example.movie_night

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movie_night.adapter.MovieListAdapter
import com.example.movie_night.data_model.Movie

class MainActivity : ComponentActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MovieListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_screen)

        val viewTicket = findViewById<Button>(R.id.myTicketButton)

        recyclerView = findViewById(R.id.recyclerViewMovies)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val movies = listOf(
            Movie(
                "Inception",
                "https://image.tmdb.org/t/p/w500/qmDpIHrmpJINaRKAfWQfftjCdyi.jpg",
                listOf("10:00 AM", "1:00 PM", "6:30 PM", "8:00 PM", "9:00 PM")
            ),
            Movie(
                "The Dark Knight",
                "https://image.tmdb.org/t/p/w500/1hRoyzDtpgMU7Dz4JF22RANzQO7.jpg",
                listOf("11:00 AM", "2:30 PM", "7:45 PM")
            ),
            Movie(
                "Interstellar",
                "https://image.tmdb.org/t/p/w500/rAiYTfKGqDCRIIqo664sY9XZIvQ.jpg",
                listOf("9:30 AM", "12:45 PM", "5:00 PM")
            ),
            Movie(
                "The Matrix",
                "https://image.tmdb.org/t/p/w500/f89U3ADr1oiB1s9GkdPOEpXUk5H.jpg",
                listOf("10:15 AM", "3:00 PM", "8:15 PM")
            ),
            Movie(
                "Avengers: Endgame",
                "https://image.tmdb.org/t/p/w500/or06FN3Dka5tukK1e9sl16pB3iy.jpg",
                listOf("11:30 AM", "2:45 PM", "7:00 PM")
            ),
            Movie(
                "Jurassic Park",
                "https://image.tmdb.org/t/p/w500/c414cDeQ9b6qLPLeKmiJuLDUREJ.jpg",
                listOf("10:00 AM", "1:30 PM", "6:00 PM")
            ),
            Movie(
                "The Lion King",
                "https://image.tmdb.org/t/p/w500/2bXbqYdUdNVa8VIWXVfclP2ICtT.jpg",
                listOf("9:00 AM", "12:00 PM", "4:00 PM")
            )
        )

        adapter = MovieListAdapter(movies) { movie, showtime ->
                confirmTicket(movie, showtime)
        }

        recyclerView.adapter = adapter

        viewTicket.setOnClickListener {
            val intent = Intent(this, TicketListActivity::class.java)
            startActivity(intent)
        }
    }

    fun confirmTicket(movie: Movie, showtime: String){
        val intent = Intent(this, ConfirmationActivity::class.java).apply {
            putExtra("MOVIE_NAME", movie.name)
            putExtra("MOVIE_URL", movie.imageUrl)
            putExtra("MOVIE_SHOWTIME", showtime)
        }
        startActivity(intent)
    }
}
