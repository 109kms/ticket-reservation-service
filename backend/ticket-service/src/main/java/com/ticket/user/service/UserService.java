package com.ticket.user.service;

import com.ticket.user.dto.request.SignupRequestDTO;
import com.ticket.user.dto.response.UserResponseDTO;

public interface UserService {

  /**
   * 회원가입
   * @param requestDTO
   * @return
   */
  UserResponseDTO signup(SignupRequestDTO requestDTO);
  
}
