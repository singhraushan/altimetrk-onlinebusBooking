package com.altimetrik.onilneBusBooking.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "BUS")
public class Bus implements Serializable/*, Comparable<Bus>*/ {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // by default AUTO
	@Column(name="BUS_ID")
	private Integer busId;

	@Column(name="BUS_NUMBER")
	private Integer busNumber;

	private String operatorName;

	private LocalDateTime departureTime;

	private LocalDateTime arrivalTime;
	
	private LocalDate returningDate;

	private Integer duration;

	private Integer price;

	private String sourceCity;

	private String destinationCity;
	
	@OneToMany(fetch=FetchType.EAGER,cascade= CascadeType.ALL, mappedBy="bus")
	@JsonManagedReference
	private List<Seat> seats= new ArrayList<Seat>();

	
	public LocalDate getReturningDate() {
		return returningDate;
	}

	public void setReturningDate(LocalDate returningDate) {
		this.returningDate = returningDate;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	public Integer getBusId() {
		return busId;
	}

	public void setBusId(Integer busId) {
		this.busId = busId;
	}

	public Integer getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(Integer busNumber) {
		this.busNumber = busNumber;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public LocalDateTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}

	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

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

	/*@Override
	public int compareTo(Bus arg0) {
		return price - arg0.price;
	}*/

}
