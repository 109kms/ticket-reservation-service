package com.ticket.reservation.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.ticket.concert.entity.Seat;
import com.ticket.user.entity.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reservations")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Reservation {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private User user;
  
  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "seat_id", nullable = false) 
  private Seat seat;
  
  @Column(nullable = false)
  private Long price;
  
  @CreatedDate
  @Column(nullable = false)
  private LocalDateTime createAt;
  
  @Builder
  public Reservation(User user, Seat seat, Long price) {
    this.user = user;
    this.seat = seat;
    this.price = price;
  }
  
  public static Reservation create(User user, Seat seat) {
    return Reservation.builder()
        .user(user)
        .seat(seat)
        .price(seat.getPrice())
        .build();
  }

}
