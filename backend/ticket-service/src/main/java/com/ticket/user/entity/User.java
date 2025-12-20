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
  
}
