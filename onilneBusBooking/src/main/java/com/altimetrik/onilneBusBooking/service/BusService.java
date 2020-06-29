package com.altimetrik.onilneBusBooking.service;

import java.util.List;

import com.altimetrik.onilneBusBooking.dto.BookingDetail;
import com.altimetrik.onilneBusBooking.dto.SearchBusDto;
import com.altimetrik.onilneBusBooking.exception.ProcessException;
import com.altimetrik.onilneBusBooking.model.Bus;
import com.altimetrik.onilneBusBooking.model.Ticket;

public interface BusService {

	public List<Bus> search(final String sourceCity,final String destinationCity,final String travelDate,final String returnDate) throws ProcessException;

	public Ticket createTicket(List<BookingDetail> bookingDetails) throws ProcessException;
	
	public String feedBus();

}
