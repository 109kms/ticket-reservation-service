package com.ticket.reservation.dto.response;

import java.time.LocalDateTime;

import com.ticket.concert.enums.SeatGrade;
import com.ticket.reservation.entity.Reservation;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReservationResponseDTO {

  private Long id;
  private Integer seatNumber;
  private SeatGrade seatGrade;
  private Long price;
  private LocalDateTime reservedAt;
  
  public static ReservationResponseDTO from(Reservation reservation) {
    return ReservationResponseDTO.builder()
        .id(reservation.getId())
        .seatNumber(reservation.getSeat().getSeatNumber())
        .seatGrade(reservation.getSeat().getSeatGrade())
        .price(reservation.getPrice())
        .reservedAt(reservation.getCreateAt())
        .build();
  }
  
}
