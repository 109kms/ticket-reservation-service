package com.ticket.concert.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "concert_schedules")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ConcertSchedule {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "concert_id", nullable = false)
  private Concert concert;
  
  @Column(nullable = false)
  private LocalDateTime startDateTime;
  
  public static ConcertSchedule create(Concert concert, LocalDateTime startDateTime) {
    ConcertSchedule cs = new ConcertSchedule();
    cs.concert = concert;
    cs.startDateTime = startDateTime;
    return cs;
  }

}
