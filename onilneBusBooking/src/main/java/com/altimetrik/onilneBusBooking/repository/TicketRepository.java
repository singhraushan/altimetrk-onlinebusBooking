package com.altimetrik.onilneBusBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.altimetrik.onilneBusBooking.model.Ticket;

public interface TicketRepository  extends JpaRepository<Ticket,Integer>{

}
