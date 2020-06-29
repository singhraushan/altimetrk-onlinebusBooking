package com.altimetrik.onilneBusBooking.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.altimetrik.onilneBusBooking.dto.BookingDetail;
import com.altimetrik.onilneBusBooking.dto.SearchBusDto;
import com.altimetrik.onilneBusBooking.exception.ProcessException;
import com.altimetrik.onilneBusBooking.model.Bus;
import com.altimetrik.onilneBusBooking.model.Person;
import com.altimetrik.onilneBusBooking.model.Ticket;
import com.altimetrik.onilneBusBooking.repository.BusRepository;
import com.altimetrik.onilneBusBooking.repository.TicketRepository;
import com.altimetrik.onilneBusBooking.service.BusService;
import com.altimetrik.onilneBusBooking.util.Utility;

@Service
public class BusServiceImpl implements BusService {

	@Autowired
	public BusRepository busRepository;

	@Autowired
	public TicketRepository ticketRepository;

	@Override
	public String feedBus() {
		busRepository.saveAll(Utility.busEntry());
		return "Successfully inserted.";
	}
	
	@Override
	public List<Bus> search(String sourceCity, String destinationCity, String travelDate, String returnDate)
			throws ProcessException {
		SearchBusDto searchBusDto = Utility.validateRequestedInputFormat(sourceCity, destinationCity, travelDate,
				returnDate);
		List<Bus> result = busRepository.findAll();

		if (searchBusDto.getReturnDate() != null) {
			return result.stream()
					.filter(bus -> bus.getReturningDate().equals(searchBusDto.getReturnDate())
							&& bus.getSourceCity().equalsIgnoreCase(searchBusDto.getSourceCity())
							&& bus.getDestinationCity().equalsIgnoreCase(searchBusDto.getDestinationCity())
							&& (bus.getDepartureTime().getDayOfYear() == searchBusDto.getTravelDate().getDayOfYear()))
					.collect(Collectors.toList());
		} else {
			List<Bus> result2 = result.stream()
					.filter(bus -> bus.getSourceCity().equalsIgnoreCase(searchBusDto.getSourceCity())
							&& bus.getDestinationCity().equalsIgnoreCase(searchBusDto.getDestinationCity()) && (bus
									.getDepartureTime().getDayOfYear() == searchBusDto.getTravelDate().getDayOfYear()))
					.collect(Collectors.toList());
			return result2;
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Ticket createTicket(List<BookingDetail> bookingDetails) throws ProcessException {
		Ticket ticket = null;
		try {
			ticket = map(bookingDetails);
		} catch (EntityNotFoundException e) {
			throw new ProcessException("Bus Id not found.See available buses.");
		}
		return ticketRepository.save(ticket);
	}
	public Ticket map(final List<BookingDetail> bookingDetails) {
		Ticket ticket = new Ticket();

		List<Person> persons = bookingDetails.stream().map(b -> {
			Person p = new Person();
			p.setName(b.getPersonName());
			p.setSeatNumber(b.getSelectedSeatNumber());
			Optional<Bus> bus = busRepository.findById(b.getSelectedBusId());
			if (bus.isPresent()) {
				Bus bc = bus.get();
				bc.getSeats().get(b.getSelectedSeatNumber() - 1).setIsAvailable(false);
				p.setBus(bc);
			} else {
				System.out.println("Bus Id not found for person:" + p.getName());
			}
			return p;
		}).collect(Collectors.toList());

		ticket.setPersons(persons);
		return ticket;
	}
}
