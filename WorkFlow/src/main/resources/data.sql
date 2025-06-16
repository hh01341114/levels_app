/*usersテーブルに値をセット*/
INSERT INTO users (id, email, name, password, department_id, role)
VALUES 
(1,'homa@co.jp', 'gene', 'password', '営業部', 'GENERAL'), 
(2,'hara@co.jp', 'admi', 'wordpass', '人事部', 'ADMIN');

/*attendanceテーブルに値をセット*/
INSERT INTO attendance (user_id, type, at)
VALUES
(1, 'IN', '2025-05-22 08:00:00'), 
(1, 'BREAK_IN', '2025-05-22 10:30:00'), 
(1, 'BREAK_OUT', '2025-05-22 11:00:00'), 
(1, 'OUT', '2025-05-22 17:00:00'), 
(2, 'IN', '2025-05-22 08:30:00'), 
(2, 'OUT', '2025-05-22 17:30:00');

INSERT INTO daily_attendance_summary (user_id, work_date, total_work_time, total_break_time, is_late, is_absent, remarks)
VALUES
(1, '2025-05-22', 8.00, 0.50, FALSE, FALSE, '通常勤務'),
(2, '2025-05-22', 9.00, 0.00, FALSE, FALSE, '通常勤務');

INSERT INTO requests (id, user_id, kind, status, target_date, submitted_at, comment)
VALUES
(1, 1, 'PAID_LEAVE', 'PENDING', '2025-05-28', NOW(), '家庭の事情'), 
(2, 1, 'PAID_LEAVE', 'PENDING', '2025-06-28', NOW(), '私情');

INSERT INTO approvals (request_id, approver_id, decision, decided_at)
VALUES
(1, 2, 'APPROVED', NOW());

INSERT INTO paidleaves (user_id, grant_date, revocation_date, days, used_days)
VALUES
(1, '2025-04-01', '2027-04-01', 10, 2);