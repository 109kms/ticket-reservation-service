package com.ticket.reservation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticket.reservation.dto.request.ReservationRequestDTO;
import com.ticket.reservation.dto.response.ReservationResponseDTO;
import com.ticket.reservation.service.ReservationService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reservations")
public class ReservationController {
  
  private final ReservationService reservationService;
  
  /**
   * 예약 생성 API
   * @param reservationRequestDTO
   * @return
   */
  @PostMapping
  public ResponseEntity<ReservationResponseDTO> makeReservation(@RequestBody @Valid ReservationRequestDTO reservationRequestDTO) {
    
    ReservationResponseDTO response = reservationService.makeReservation(reservationRequestDTO);
    
    return ResponseEntity.ok(response);
    
  }

}
