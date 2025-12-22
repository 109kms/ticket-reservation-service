package com.ticket.concert.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticket.concert.entity.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long>{

}
