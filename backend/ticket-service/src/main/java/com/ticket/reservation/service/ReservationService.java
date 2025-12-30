package com.ticket.reservation.service;

import com.ticket.reservation.dto.request.ReservationRequestDTO;
import com.ticket.reservation.dto.response.ReservationResponseDTO;

public interface ReservationService {
  
  // 좌석 임시 점유
  ReservationResponseDTO makeReservation(ReservationRequestDTO requestDTO);
  
  // 예약 확정 (결제 완료)
  ReservationResponseDTO confirmReservation(Long reservationId);
  
}
