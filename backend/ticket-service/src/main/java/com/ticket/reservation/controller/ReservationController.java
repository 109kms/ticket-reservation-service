package com.ticket.reservation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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
   * 예약 생성 API (좌석 점유)
   * @param reservationRequestDTO
   * @return
   */
  @PostMapping
  public ResponseEntity<ReservationResponseDTO> makeReservation(@RequestBody @Valid ReservationRequestDTO reservationRequestDTO) {
    
    ReservationResponseDTO response = reservationService.makeReservation(reservationRequestDTO);
    
    return ResponseEntity.ok(response);
    
  }
  
  /**
   * 예약 확정 API
   * @param reservationId
   * @return
   */
  @PostMapping("/{id}/confirm")
  public ResponseEntity<ReservationResponseDTO> confirmReservation(@PathVariable("id") Long reservationId) {
    
    ReservationResponseDTO response = reservationService.confirmReservation(reservationId);
    
    return ResponseEntity.ok(response);
    
  }

}
