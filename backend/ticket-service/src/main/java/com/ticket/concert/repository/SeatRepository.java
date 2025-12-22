package com.ticket.concert.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticket.concert.entity.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long>{
  
  List<Seat> findByConcertScheduleIdOrderBySeatNumberAsc(Long scheduleId);

}
