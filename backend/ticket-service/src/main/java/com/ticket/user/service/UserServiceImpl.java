package com.ticket.user.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ticket.user.dto.request.SignupRequestDTO;
import com.ticket.user.dto.response.UserResponseDTO;
import com.ticket.user.entity.User;
import com.ticket.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
  
  private final UserRepository userRepository;

  @Override
  public UserResponseDTO signup(SignupRequestDTO requestDTO) {
    // 이메일 중복 검사
    if (userRepository.existsByEmail(requestDTO.getEmail())) {
      throw new IllegalArgumentException("이미 사용 중인 이메일입니다.");
    }
    
    // 비밀번호 암호화
    String encodedPassword = requestDTO.getPassword();
    
    // User 엔티티 생성
    User user = requestDTO.toEntity(encodedPassword);
    
    // 저장
    User savedUser = userRepository.save(user);
    
    // DTO로 변환 후 반환
    return UserResponseDTO.from(savedUser);
  }

}
