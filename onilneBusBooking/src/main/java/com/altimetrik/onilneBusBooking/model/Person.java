package com.altimetrik.onilneBusBooking.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
@Table(name = "PERSON")
public class Person implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // by default AUTO
	@Column(nullable = false, unique = true)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="TICKET_ID",insertable=true, updatable=true)
	@JsonBackReference
	private Ticket ticket;
	
	private String name;
	
	/*@Column(name="BUS_ID")
	private int busId;*/
	
	@OneToOne
	@JoinColumn(name="bus_id")
	//@OneToOne(fetch=FetchType.EAGER,cascade= CascadeType.ALL, mappedBy="bus")
	@JsonManagedReference
	private Bus bus;
	
	private Integer seatNumber;

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public Integer getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(Integer seatNumber) {
		this.seatNumber = seatNumber;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*public int getBusId() {
		return busId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
	}*/

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}
}
