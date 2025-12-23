-- 테스트 사용자
INSERT INTO users (email, password, name, point) VALUES ('test@test.com', 'a1234567890', '테스터', 0);

-- 1. 공연 생성
INSERT INTO concerts (title, description) VALUES 
('아이유 2025 콘서트', '최고의 감동을 선사합니다.');

-- 2. 스케줄 생성
INSERT INTO concert_schedules (concert_id, start_date_time) VALUES 
(1, '2025-12-25 19:00:00');

-- 3. 좌석 생성

-- VIP석 (1~5번)
INSERT INTO seats (schedule_id, seat_number, seat_grade, price, seat_status, version) VALUES (1, 1, 'VIP', 100000, 'AVAILABLE', 0);
INSERT INTO seats (schedule_id, seat_number, seat_grade, price, seat_status, version) VALUES (1, 2, 'VIP', 100000, 'AVAILABLE', 0);
INSERT INTO seats (schedule_id, seat_number, seat_grade, price, seat_status, version) VALUES (1, 3, 'VIP', 100000, 'AVAILABLE', 0);
INSERT INTO seats (schedule_id, seat_number, seat_grade, price, seat_status, version) VALUES (1, 4, 'VIP', 100000, 'SOLD', 0);
INSERT INTO seats (schedule_id, seat_number, seat_grade, price, seat_status, version) VALUES (1, 5, 'VIP', 100000, 'AVAILABLE', 0);

-- R석 (6~10번)
INSERT INTO seats (schedule_id, seat_number, seat_grade, price, seat_status, version) VALUES (1, 6, 'R', 80000, 'AVAILABLE', 0);
INSERT INTO seats (schedule_id, seat_number, seat_grade, price, seat_status, version) VALUES (1, 7, 'R', 80000, 'AVAILABLE', 0);
INSERT INTO seats (schedule_id, seat_number, seat_grade, price, seat_status, version) VALUES (1, 8, 'R', 80000, 'AVAILABLE', 0);
INSERT INTO seats (schedule_id, seat_number, seat_grade, price, seat_status, version) VALUES (1, 9, 'R', 80000, 'AVAILABLE', 0);
INSERT INTO seats (schedule_id, seat_number, seat_grade, price, seat_status, version) VALUES (1, 10, 'R', 80000, 'AVAILABLE', 0);

-- S석 (11~15번)
INSERT INTO seats (schedule_id, seat_number, seat_grade, price, seat_status, version) VALUES (1, 11, 'S', 50000, 'AVAILABLE', 0);
INSERT INTO seats (schedule_id, seat_number, seat_grade, price, seat_status, version) VALUES (1, 12, 'S', 50000, 'AVAILABLE', 0);
INSERT INTO seats (schedule_id, seat_number, seat_grade, price, seat_status, version) VALUES (1, 13, 'S', 50000, 'AVAILABLE', 0);
INSERT INTO seats (schedule_id, seat_number, seat_grade, price, seat_status, version) VALUES (1, 14, 'S', 50000, 'AVAILABLE', 0);
INSERT INTO seats (schedule_id, seat_number, seat_grade, price, seat_status, version) VALUES (1, 15, 'S', 50000, 'AVAILABLE', 0);