package com.ticket.reservation.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ticket.concert.entity.Seat;
import com.ticket.concert.repository.SeatRepository;
import com.ticket.reservation.dto.request.ReservationRequestDTO;
import com.ticket.reservation.dto.response.ReservationResponseDTO;
import com.ticket.reservation.entity.Reservation;
import com.ticket.reservation.repository.ReservationRepository;
import com.ticket.user.entity.User;
import com.ticket.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReservationServiceImpl implements ReservationService {
  
  private final ReservationRepository reservationRepository;
  private final UserRepository userRepository;
  private final SeatRepository seatRepository;

  @Override
  @Transactional
  public ReservationResponseDTO makeReservation(ReservationRequestDTO requestDTO) {
    
    User user = userRepository.findById(requestDTO.getUserId())
        .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자입니다."));
    
    Seat seat = seatRepository.findById(requestDTO.getSeatId())
        .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 좌석입니다."));
    
    user.usePoint(seat.getPrice());  // 포인트 사용
    
    seat.confirm(); // 좌석 확정처리
    
    Reservation reservation = Reservation.create(user, seat);  // 예약 엔티티 생성
    
    Reservation saveReservation = reservationRepository.save(reservation);  // 저장
    
    return ReservationResponseDTO.from(saveReservation);  // dto로 변환
  }

}
