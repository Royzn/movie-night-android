package com.example.movie_night.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movie_night.R
import com.example.movie_night.data_model.Ticket

class TicketListAdapter(
    private val tickets: List<Ticket>,
    private val onViewDetailsClick: (ticket: Ticket) -> Unit
) : RecyclerView.Adapter<TicketListAdapter.TicketViewHolder>() {

    inner class TicketViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textTicketId: TextView = view.findViewById(R.id.textTicketId)
        val imageMovie: ImageView = view.findViewById(R.id.imageMovie)
        val textMovieName: TextView = view.findViewById(R.id.textMovieName)
        val textSelectedShowtime: TextView = view.findViewById(R.id.textSelectedShowtime)
        val textQuantity: TextView = view.findViewById(R.id.textQuantity)
        val buttonViewDetails: Button = view.findViewById(R.id.buttonViewDetails)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.ticket_card, parent, false)
        return TicketViewHolder(view)
    }

    override fun getItemCount() = tickets.size

    override fun onBindViewHolder(holder: TicketViewHolder, position: Int) {
        val ticket = tickets[position]

        holder.textTicketId.text = "Ticket ID: ${ticket.ticketId}"
        holder.textMovieName.text = ticket.movieName
        holder.textSelectedShowtime.text = "Showtime: ${ticket.selectedShowtime}"
        holder.textQuantity.text = "Quantity: ${ticket.qty}"

        Glide.with(holder.imageMovie.context)
            .load(ticket.movieImage)
            .placeholder(android.R.drawable.ic_menu_report_image)  // Replace with your placeholder drawable if needed
            .into(holder.imageMovie)

        holder.buttonViewDetails.setOnClickListener {
            onViewDetailsClick(ticket)
        }
    }
}
