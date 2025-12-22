package com.ticket.concert.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ticket.concert.dto.response.SeatResponseDTO;
import com.ticket.concert.repository.SeatRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ConcertServiceImpl implements ConcertService {
  
  private final SeatRepository seatRepository;

  @Override
  public List<SeatResponseDTO> getSeats(Long scheduleId) {
    return seatRepository.findByConcertScheduleIdOrderBySeatNumberAsc(scheduleId)
        .stream()
        .map(SeatResponseDTO::from)
        .collect(Collectors.toList());
  }

}
