package com.example.movie_night.service

import com.example.movie_night.data_model.Ticket

object TicketService {

    private val ticketList: MutableList<Ticket> = mutableListOf()

    fun addTicket(quantity: Int, movieName: String, movieImage: String, movieShowtime: String){
        val newTick = Ticket.create(quantity, movieName, movieShowtime, movieImage)
        ticketList.add(newTick)
    }

    fun getTickets(): List<Ticket>{
        return ticketList
    }
}