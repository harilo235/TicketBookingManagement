package com.hari.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hari.entities.Ticket;
import com.hari.services.TicketBookingServices;

@RestController
@RequestMapping(value="api/tickets")
public class TicketBookingController {

	@Autowired
	private TicketBookingServices ticketBookingServices;

	@PostMapping(value="/create")
	public Ticket createTicket(@RequestBody Ticket ticket) {
		// some code to check paymentr
		
		return ticketBookingServices.createTicket(ticket);	
		
	}
	
	@GetMapping(value="/ticketbyid/{ticketId}")
	public Ticket getTicketById(@PathVariable("ticketId")Integer ticketId) {
		return ticketBookingServices.getTicketById(ticketId);
	}
	
	@GetMapping(value="/ticketbysourcestation/{sourcestation}")
	public List<Ticket> getTicketById(@PathVariable("sourcestation")String sourceStation) {
		return ticketBookingServices.getTicketBySourceStation(sourceStation);
	}
	
	
	@GetMapping(value="/ticket/alltickets")
	public Iterable<Ticket> getAllBookedTickets(){
		return ticketBookingServices.getAllBookedTickets();
	}
	
	@DeleteMapping(value="/ticket/{ticketId}")
	public void deleteTicket(@PathVariable("ticketId")Integer ticketId) {
		ticketBookingServices.deleteTicket(ticketId);
	} 
	
	@PutMapping(value="/ticket/(ticketId)/(newEmail:.+)")
	public Ticket updateTicket(@PathVariable("ticketId")Integer ticketId,@PathVariable("newEmail")String newEmail) {
		return ticketBookingServices.updateTicket(ticketId, newEmail);
	} 
	
	@GetMapping(value="/ticket/getmockticket")
	public Ticket getMockTicket() {
		return new Ticket();
	}
	
	}



