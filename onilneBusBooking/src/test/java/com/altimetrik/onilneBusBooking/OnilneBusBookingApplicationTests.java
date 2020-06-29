package com.altimetrik.onilneBusBooking;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.altimetrik.onilneBusBooking.dto.BookingDetail;
import com.altimetrik.onilneBusBooking.exception.ProcessException;
import com.altimetrik.onilneBusBooking.model.Bus;
import com.altimetrik.onilneBusBooking.model.Ticket;
import com.altimetrik.onilneBusBooking.repository.BusRepository;
import com.altimetrik.onilneBusBooking.repository.TicketRepository;
import com.altimetrik.onilneBusBooking.service.impl.BusServiceImpl;
import com.altimetrik.onilneBusBooking.util.Utility;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class OnilneBusBookingApplicationTests {

	@Autowired
	private BusRepository busRepository;
	@Autowired
	private TicketRepository ticketRepository;
	
	BusServiceImpl busServiceIpl = new BusServiceImpl();
	List<Bus> b;

	@Before
	public void setUp() {
		busServiceIpl.busRepository = busRepository;
		busServiceIpl.ticketRepository= ticketRepository;
		b = busRepository.saveAll(Utility.busEntry());
	}

	@Test
	public void busFeed() {
		assertEquals(2, b.size());
	}

	@Test
	public void getBuses() throws ProcessException {
		List<Bus> buses = busServiceIpl.search("Chennai-0", "Bangalore-0", "2020-06-29", "");
		Assert.assertTrue(buses.size()>0);
	}

	@Test
	public void createTicket() throws ProcessException {
		BookingDetail bookingDetail = new BookingDetail();
		bookingDetail.setPersonName("Raushan");
		bookingDetail.setSelectedSeatNumber(1);
		bookingDetail.setSelectedBusId(1);
		List<BookingDetail> bookingDetails = new ArrayList<BookingDetail>();
		bookingDetails.add(bookingDetail);
		Ticket tkt = busServiceIpl.createTicket(bookingDetails);
		assertEquals(false, tkt.getPersons().get(0).getBus().getSeats().get(0).getIsAvailable());
	}

}
