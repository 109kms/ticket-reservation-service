package com.ticket.concert.dto.response;

import com.ticket.concert.entity.Seat;
import com.ticket.concert.enums.SeatGrade;
import com.ticket.concert.enums.SeatStatus;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SeatResponseDTO {
  
  private Long id;
  private Integer seatNumber;
  private SeatGrade seatGrade;
  private Long price;
  private SeatStatus seatStatus;
  
  // 엔티티 -> DTO 변환 메소드
  public static SeatResponseDTO from(Seat seat) {
    return SeatResponseDTO.builder()
        .id(seat.getId())
        .seatNumber(seat.getSeatNumber())
        .seatGrade(seat.getSeatGrade())
        .price(seat.getPrice())
        .seatStatus(seat.getSeatStatus())
        .build();
  }
  
}
