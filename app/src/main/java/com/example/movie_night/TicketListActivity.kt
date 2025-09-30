package com.example.movie_night

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movie_night.adapter.TicketListAdapter
import com.example.movie_night.service.TicketService

class TicketListActivity: ComponentActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: TicketListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ticket_screen)

        recyclerView = findViewById(R.id.recyclerListTickets)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val ticketList = TicketService.getTickets()
        val backButton = findViewById<Button>(R.id.backButton)

        adapter = TicketListAdapter(ticketList){ ticket ->
            val intent = Intent(this, TicketDetailActivity::class.java).apply {
                putExtra("EXTRA_TICKET_ID", ticket.ticketId)
                putExtra("EXTRA_MOVIE_NAME", ticket.movieName)
                putExtra("EXTRA_SHOWTIME", ticket.selectedShowtime)
                putExtra("EXTRA_QUANTITY", ticket.qty)
                putExtra("EXTRA_MOVIE_IMAGE", ticket.movieImage)
            }
            startActivity(intent)
        }

        recyclerView.adapter = adapter

        backButton.setOnClickListener {
            finish()
        }
    }
}