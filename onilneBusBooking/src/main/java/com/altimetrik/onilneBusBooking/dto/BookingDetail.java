package com.altimetrik.onilneBusBooking.dto;

public class BookingDetail {

	private String personName;
	Integer selectedSeatNumber;
	private Integer selectedBusId;

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public Integer getSelectedSeatNumber() {
		return selectedSeatNumber;
	}

	public void setSelectedSeatNumber(Integer selectedSeatNumber) {
		this.selectedSeatNumber = selectedSeatNumber;
	}

	public Integer getSelectedBusId() {
		return selectedBusId;
	}

	public void setSelectedBusId(Integer selectedBusId) {
		this.selectedBusId = selectedBusId;
	}

}
