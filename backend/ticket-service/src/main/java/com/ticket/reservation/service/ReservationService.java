package com.ticket.reservation.service;

import com.ticket.reservation.dto.request.ReservationRequestDTO;
import com.ticket.reservation.dto.response.ReservationResponseDTO;

public interface ReservationService {
  ReservationResponseDTO makeReservation(ReservationRequestDTO requestDTO);
}
