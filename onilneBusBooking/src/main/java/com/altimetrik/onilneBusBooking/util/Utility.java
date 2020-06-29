package com.altimetrik.onilneBusBooking.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.altimetrik.onilneBusBooking.dto.SearchBusDto;
import com.altimetrik.onilneBusBooking.exception.ProcessException;
import com.altimetrik.onilneBusBooking.model.Bus;
import com.altimetrik.onilneBusBooking.model.Seat;

public class Utility {

	public static List<Bus> busEntry() {
		List<Bus> buses = new ArrayList<Bus>();

		for (int b = 0; b <= 1; b++) {
			Bus bus = new Bus();
			bus.setArrivalTime(LocalDateTime.now().plusDays(b + 1));
			bus.setBusNumber(2020 + b);
			bus.setDepartureTime(LocalDateTime.now().plusDays(b));
			bus.setDestinationCity("Bangalore-" + b);
			bus.setDuration(9);
			bus.setOperatorName("Alok-" + b);
			bus.setPrice(650);
			bus.setReturningDate(LocalDate.now().plusDays(b + 2));
			bus.setSourceCity("Chennai-" + b);
			List<Seat> seats = new ArrayList<Seat>();
			for (int seat = 1; seat <= 60; seat++) {
				Seat st = new Seat();
				st.setSeatNumber(seat);
				st.setIsAvailable(true);
				st.setBus(bus);
				seats.add(st);
			}
			bus.setSeats(seats);
			buses.add(bus);
		}

		return buses;
	}
	
	public static SearchBusDto validateRequestedInputFormat(String sourceCity, String destinationCity, String travelDate, String returnDate) throws ProcessException {
		LocalDate tDate = null, rDate = null;
		try {
			tDate = LocalDate.parse(travelDate);
			if (returnDate != null && !returnDate.trim().isEmpty()) {
				rDate = LocalDate.parse(returnDate);
			}
		} catch (Exception e) {

			throw new ProcessException("Date Parsing failed. please provide date in 'YYYY-MM-DD' format ");
		}
		return new SearchBusDto(sourceCity, destinationCity, tDate, rDate);
	}

}
