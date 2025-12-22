package com.ticket.concert.service;

import java.util.List;

import com.ticket.concert.dto.response.SeatResponseDTO;

public interface ConcertService {
  
  List<SeatResponseDTO> getSeats(Long scheduleId);

}
