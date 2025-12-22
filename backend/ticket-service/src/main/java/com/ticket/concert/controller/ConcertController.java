package com.ticket.concert.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticket.concert.dto.response.SeatResponseDTO;
import com.ticket.concert.service.ConcertService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/concerts")
public class ConcertController {
  
  private final ConcertService concertService;
  
  @GetMapping("/schedules/{scheduleId}/seats")
  public ResponseEntity<List<SeatResponseDTO>> getSeats(@PathVariable("scheduleId") Long scheduleId) {
    
    List<SeatResponseDTO> seats = concertService.getSeats(scheduleId);
    
    return ResponseEntity.ok(seats);
    
  }

}
