package com.altimetrik.onilneBusBooking.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.altimetrik.onilneBusBooking.dto.BookingDetail;
import com.altimetrik.onilneBusBooking.exception.ProcessException;
import com.altimetrik.onilneBusBooking.model.Bus;
import com.altimetrik.onilneBusBooking.model.Ticket;
import com.altimetrik.onilneBusBooking.service.BusService;

import io.swagger.annotations.ApiOperation;

/**
 * @author Raushan kumar
 *
 */
@RestController
public class BusController {

	@Autowired
	BusService busService;

	@ApiOperation(value = "Get search result of buses")
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public List<Bus> getBuses(@RequestParam("sourceCity") String sourceCity,
			@RequestParam("destinationCity") String destinationCity,
			@RequestParam(required = false, name = "returnDate") String returnDate,
			@RequestParam("travelDate") String travelDate) throws ProcessException {

		return busService.search(sourceCity, destinationCity, travelDate, returnDate);
	}

	@ApiOperation(value = "Book ticket for selected seats")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Ticket createTicket(@RequestBody List<BookingDetail> bookingDetails) throws ProcessException {
		return busService.createTicket(bookingDetails);
	}

	@ApiOperation(value = "Feed bus entry")
	@RequestMapping(value = "/feedBus", method = RequestMethod.POST)
	public String feedBus() {
		return busService.feedBus();
	}

}
