package com.ticket.concert.entity;

import com.ticket.concert.enums.SeatGrade;
import com.ticket.concert.enums.SeatStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "seats")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Seat {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "schedule_id", nullable = false)
  private ConcertSchedule concertSchedule;

  @Column(nullable = false)
  private Integer seatNumber;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private SeatGrade seatGrade;

  @Column(nullable = false)
  private Long price;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private SeatStatus seatStatus;
  
  // 낙관적 락(Optimistic Lock)을 위한 버전 정보
  @Version
  private Long version;

  public static Seat create(ConcertSchedule concertSchedule, Integer seatNumber, SeatGrade seatGrade, Long price) {
    Seat s = new Seat();
    s.concertSchedule = concertSchedule;
    s.seatNumber = seatNumber;
    s.seatGrade = seatGrade;
    s.price = price;
    s.seatStatus = SeatStatus.AVAILABLE;
    return s;
  }

  // 비즈니스 로직 // 

  /*
   * 예약 시도
   */
  public void reserve() {
    if (this.seatStatus != SeatStatus.AVAILABLE) {
      throw new IllegalStateException("이미 예약된 좌석입니다.");
    }
    this.seatStatus = SeatStatus.TEMPORARY_RESERVED;
  }
  
  public void confirm() {
    if (this.seatStatus != SeatStatus.AVAILABLE && this.seatStatus != SeatStatus.TEMPORARY_RESERVED) {
      throw new IllegalStateException("예약 가능한 상태가 아닙니다.");
    }
    this.seatStatus = SeatStatus.SOLD;
  }

}
