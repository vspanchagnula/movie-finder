package com.movieapp.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.movieapp.data.entity.Ticket;

import java.util.List;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, Long> {
    List<Ticket> findByScreeningId(long screeningId);
}
