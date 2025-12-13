# 🎫 대용량 트래픽 처리를 위한 선착순 예매 시스템 (Ticket-Service)

> **"수만 명이 동시에 접속해도 안정적인 티켓 예매 서비스"** > 대규모 트래픽 상황에서 발생할 수 있는 **동시성 이슈(Concurrency Issue)**를 해결하고,  
> **데이터 무결성**을 보장하는 것에 중점을 둔 백엔드 중심의 토이 프로젝트입니다.

---

## 📅 프로젝트 기간
- **기간:** 2025.12 ~ (진행 중)
- **인원:** 개인 프로젝트 (Backend & Frontend)

## 🛠️ 기술 스택 (Tech Stack)

### Backend
- **Java 17**, **Spring Boot 3.x**
- **JPA (Hibernate)**, QueryDSL
- **MySQL**, **H2** (Test)
- **Redis** (Cache & Distributed Lock)
- **Docker**

### Frontend
- **React**, JavaScript
- **Axios**

---

## 🎯 기획 배경 및 목표

인기 아이돌의 콘서트 티켓팅이나 명절 기차표 예매 상황에서는 **수천 건의 요청이 0.1초 안에 집중**됩니다.
이 과정에서 발생하는 기술적 챌린지를 직접 해결해보고자 주제를 선정했습니다.

### 핵심 해결 과제
1.  **동시성 제어 (Concurrency Control):**
    - 좌석이 딱 1개 남았을 때, 100명이 동시에 결제 버튼을 누르면 어떻게 될까?
    - `Synchronized`, `DB Lock(Pessimistic/Optimistic)`, `Redis Distributed Lock`을 단계별로 적용해보며 **동시성 문제(Race Condition)**를 완벽하게 차단합니다.
2.  **대기열 시스템 (Waiting Queue):**
    - 서버가 다운되지 않도록 트래픽을 제어하는 대기열 시스템 구현.
3.  **트랜잭션 및 데이터 정합성:**
    - 결제 도중 실패했을 때 포인트와 좌석 상태를 안전하게 롤백.

---

## 💡 주요 기능 (Features)

### 1. 유저 (User)
- 포인트 충전 및 조회 (결제 기능을 포인트로 대체하여 트랜잭션 로직 집중)
- 로그인/회원가입

### 2. 공연 및 예약 (Concert & Reservation)
- 날짜별 공연 회차 및 예약 가능 좌석 조회
- **좌석 점유 (임시 배정):** 좌석 선택 시 5분간 타인의 접근을 막음 (Redis 활용 예정)
- **예약 확정:** 포인트 차감 후 최종 예약 완료

---

## 🏗️ ERD 설계 (Database Design)
*(추후 설계 완료 후 이미지를 첨부할 예정입니다)*
- `User` (사용자)
- `PointHistory` (포인트 내역)
- `Concert` (공연 정보)
- `ConcertSchedule` (스케줄)
- `Seat` (좌석 - 동시성 제어의 핵심)
- `Reservation` (예약 정보)

---

## 🔥 트러블 슈팅 (Trouble Shooting)
*(프로젝트를 진행하며 겪은 기술적 문제와 해결 과정을 기록하는 공간입니다)*

### Case 1. 좌석 중복 예약 문제
- **문제:** JMeter 부하 테스트 결과, 1개의 좌석에 3명의 예약이 생성됨.
- **원인:** 조회(Select)와 갱신(Update) 사이에 틈이 생겨 Race Condition 발생.
- **해결:** (예정) JPA 비관적 락(Pessimistic Lock) 적용 후 해결 여부 테스트.

---
