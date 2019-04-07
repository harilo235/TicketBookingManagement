package com.hari.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hari.entities.Ticket;

@Repository
public interface TicketBookingRepository extends JpaRepository<Ticket, Integer> {

Ticket findTicketByTicketId(Integer id);
List<Ticket> findTicketBySourceStation(String sourceStation);
}
