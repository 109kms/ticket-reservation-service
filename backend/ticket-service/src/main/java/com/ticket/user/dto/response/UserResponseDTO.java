package com.ticket.user.dto.response;

import com.ticket.user.entity.User;

import lombok.Getter;

/**
 * 사용자 응답 DTO
 */
@Getter
public class UserResponseDTO {
  
  private final Long id;
  private final String email;
  private final String name;
  private final Long point;
  
  // Entity -> DTO 변환 생성자
  public UserResponseDTO(User user) {
    this.id = user.getId();
    this.email = user.getEmail();
    this.name = user.getName();
    this.point = user.getPoint();
  }
  
  public static UserResponseDTO from(User user) {
    return new UserResponseDTO(user);
  }

}
