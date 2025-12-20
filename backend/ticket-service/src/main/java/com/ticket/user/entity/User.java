package com.ticket.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "users")
@Getter
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(nullable = false, unique = true)
  private String email;
  
  @Column(nullable = false)
  private String password;
  
  @Column(nullable = false)
  private String name;
  
  @Column(nullable = false)
  private Long point = 0L;
  
  // 정적 팩토리 메소드
  public static User create(String email, String password, String name) {
    User u = new User();
    u.email = email;
    u.password = password;
    u.name = name;
    u.point = 0L;
    return u;
  }
  
  // 비즈니스 로직
  
  /*
   * 포인트 충전
   */
  public void chargePoint(Long amount) {
    if (amount == null || amount <= 0) {
      throw new IllegalArgumentException("충전 금액은 0보다 커야 합니다.");
    }
    this.point += amount;
  }
  
  /*
   * 포인트 사용(결제)
   */
  public void usePoint(Long amount) {
    if (amount == null || amount <= 0) {
      throw new IllegalArgumentException("사용 금액은 0보다 커야 합니다.");
    }
    if (this.point < amount) {
      throw new IllegalArgumentException("포인트가 부족합니다.");
    }
    this.point -= amount;
  }
  
}
