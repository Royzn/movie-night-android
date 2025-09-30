package com.example.movie_night.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movie_night.R
import com.example.movie_night.data_model.Movie

class MovieListAdapter(
    private val movies: List<Movie>,
    private val onShowtimeClick: (movie: Movie, showtime: String) -> Unit
) : RecyclerView.Adapter<MovieListAdapter.MovieViewHolder>() {

    inner class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageMovie: ImageView = view.findViewById(R.id.imageMovie)
        val textMovieName: TextView = view.findViewById(R.id.textMovieName)
        val showtimesContainer: GridLayout = view.findViewById(R.id.showtimesContainer)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount() = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.textMovieName.text = movie.name

        Glide.with(holder.imageMovie.context)
            .load(movie.imageUrl)
            .placeholder(android.R.drawable.ic_menu_report_image)  // Make sure you have this drawable or change it
            .into(holder.imageMovie)

        holder.showtimesContainer.removeAllViews()

        movie.showtimes.forEach { time ->
            val button = Button(holder.showtimesContainer.context).apply {
                text = time
                setOnClickListener { onShowtimeClick(movie, time) }
            }
            val params = GridLayout.LayoutParams().apply {
                width = GridLayout.LayoutParams.WRAP_CONTENT
                height = GridLayout.LayoutParams.WRAP_CONTENT
                setMargins(8, 8, 8, 8)  // spacing between buttons
            }
            button.layoutParams = params
            holder.showtimesContainer.addView(button)
        }
    }
}
