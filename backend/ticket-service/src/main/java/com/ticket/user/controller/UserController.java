package com.ticket.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticket.user.dto.request.SignupRequestDTO;
import com.ticket.user.dto.response.UserResponseDTO;
import com.ticket.user.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;
  
  public ResponseEntity<UserResponseDTO> signup(@Valid @RequestBody SignupRequestDTO requestDTO) {
    UserResponseDTO responseDTO = userService.signup(requestDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
  }
  
}
