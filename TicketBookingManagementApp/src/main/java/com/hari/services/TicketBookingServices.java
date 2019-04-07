package com.hari.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hari.entities.Ticket;
import com.hari.repository.TicketBookingRepository;

@Service
public class TicketBookingServices {

	@Autowired
	private TicketBookingRepository ticketBookingRepository;
	
	public Ticket createTicket(Ticket ticket) {
	
		return ticketBookingRepository.save(ticket);
		
	}
	public Ticket getTicketById(Integer ticketId) {
		return ticketBookingRepository.findTicketByTicketId(ticketId);
	}
	public Iterable<Ticket> getAllBookedTickets(){
		return ticketBookingRepository.findAll();
	}
	public void deleteTicket(Integer ticketId) {
		ticketBookingRepository.deleteById(ticketId);
	}
	public Ticket updateTicket(Integer ticketId, String newEmail) {
		Ticket ticketFromDb = ticketBookingRepository.findTicketByTicketId(ticketId);
		ticketFromDb.setEmail(newEmail);
		Ticket updatedTicket = ticketBookingRepository.save(ticketFromDb);
		return updatedTicket;
	}
	public List<Ticket> getTicketBySourceStation(String sourceStation) {
		// TODO Auto-generated method stub
		return ticketBookingRepository.findTicketBySourceStation(sourceStation);
	}
	
	
	
}