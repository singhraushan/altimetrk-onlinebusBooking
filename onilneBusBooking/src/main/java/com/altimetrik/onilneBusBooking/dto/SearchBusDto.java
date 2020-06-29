package com.altimetrik.onilneBusBooking.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

public class SearchBusDto {
	
	
	
	
	public SearchBusDto(@NotNull String sourceCity, @NotNull String destinationCity, @NotNull LocalDate travelDate,
			LocalDate returnDate) {
		super();
		this.sourceCity = sourceCity;
		this.destinationCity = destinationCity;
		this.travelDate = travelDate;
		this.returnDate = returnDate;
	}

	@NotNull
	private String sourceCity;

	@NotNull
	private String destinationCity;
	@NotNull
	private LocalDate travelDate;

	private LocalDate returnDate;

	public String getSourceCity() {
		return sourceCity;
	}

	public void setSourceCity(String sourceCity) {
		this.sourceCity = sourceCity;
	}

	public String getDestinationCity() {
		return destinationCity;
	}

	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}

	public LocalDate getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(LocalDate travelDate) {
		this.travelDate = travelDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}
	
	
	

}
