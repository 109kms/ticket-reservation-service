-- 1. 공연 생성 (아이유 콘서트)
INSERT INTO concerts (title, description) VALUES 
('아이유 2025 콘서트', '최고의 감동을 선사합니다.');

-- 2. 스케줄 생성 (1번 공연, 12월 25일)
INSERT INTO concert_schedules (concert_id, start_date_time) VALUES 
(1, '2025-12-25 19:00:00');

-- 3. 좌석 생성 (1번 스케줄에 대한 좌석들)
-- VIP석 (1~5번) : 10만원
INSERT INTO seats (schedule_id, seat_number, grade, price, status, version) VALUES (1, 1, 'VIP', 100000, 'AVAILABLE', 0);
INSERT INTO seats (schedule_id, seat_number, grade, price, status, version) VALUES (1, 2, 'VIP', 100000, 'AVAILABLE', 0);
INSERT INTO seats (schedule_id, seat_number, grade, price, status, version) VALUES (1, 3, 'VIP', 100000, 'AVAILABLE', 0);
INSERT INTO seats (schedule_id, seat_number, grade, price, status, version) VALUES (1, 4, 'VIP', 100000, 'SOLD', 0); -- 하나는 이미 팔린걸로 테스트
INSERT INTO seats (schedule_id, seat_number, grade, price, status, version) VALUES (1, 5, 'VIP', 100000, 'AVAILABLE', 0);

-- R석 (6~10번) : 8만원
INSERT INTO seats (schedule_id, seat_number, grade, price, status, version) VALUES (1, 6, 'R', 80000, 'AVAILABLE', 0);
INSERT INTO seats (schedule_id, seat_number, grade, price, status, version) VALUES (1, 7, 'R', 80000, 'AVAILABLE', 0);
INSERT INTO seats (schedule_id, seat_number, grade, price, status, version) VALUES (1, 8, 'R', 80000, 'AVAILABLE', 0);
INSERT INTO seats (schedule_id, seat_number, grade, price, status, version) VALUES (1, 9, 'R', 80000, 'AVAILABLE', 0);
INSERT INTO seats (schedule_id, seat_number, grade, price, status, version) VALUES (1, 10, 'R', 80000, 'AVAILABLE', 0);

-- S석 (11~15번) : 5만원
INSERT INTO seats (schedule_id, seat_number, grade, price, status, version) VALUES (1, 11, 'S', 50000, 'AVAILABLE', 0);
INSERT INTO seats (schedule_id, seat_number, grade, price, status, version) VALUES (1, 12, 'S', 50000, 'AVAILABLE', 0);
INSERT INTO seats (schedule_id, seat_number, grade, price, status, version) VALUES (1, 13, 'S', 50000, 'AVAILABLE', 0);
INSERT INTO seats (schedule_id, seat_number, grade, price, status, version) VALUES (1, 14, 'S', 50000, 'AVAILABLE', 0);
INSERT INTO seats (schedule_id, seat_number, grade, price, status, version) VALUES (1, 15, 'S', 50000, 'AVAILABLE', 0);