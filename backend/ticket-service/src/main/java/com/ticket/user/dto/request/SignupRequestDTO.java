package com.ticket.user.dto.request;

import com.ticket.user.entity.User;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 회원가입 요청 DTO
 */
@Getter
@NoArgsConstructor
public class SignupRequestDTO {

  private String email;
  
  private String password;
  
  private String name;
  
  public User toEntity(String encodedPassword) {
    return User.create(this.email, encodedPassword, this.name);
  }
  
}
