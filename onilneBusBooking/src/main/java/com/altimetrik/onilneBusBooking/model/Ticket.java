package com.altimetrik.onilneBusBooking.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
@Table(name = "TICKET")
public class Ticket implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // by default AUTO
	@Column(name = "TICKET_ID", nullable = false, unique = true)
	private Integer ticketId;
	
	@OneToMany(fetch=FetchType.EAGER, cascade= CascadeType.ALL,mappedBy="ticket")
	@JsonManagedReference
	//@JoinColumn(name = "ID", referencedColumnName="ID")
	private List<Person> persons;

	

	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
   
	
}
