package com.ticket.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticket.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
  
  /**
   * 이메일로 사용자 정보를 조회
   * 반환 타입이 Optional인 이유는 찾는 유저가 없을 수도 있기 때문이다.(null 방지)
   * @param email
   * @return
   */
  Optional<User> findByEmail(String email);
  
  /**
   * 이메일 중복 여부 확인
   * @param email
   * @return
   */
  boolean existsByEmail(String email);

}
