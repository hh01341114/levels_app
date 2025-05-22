
/*usersテーブル作成*/
CREATE TABLE IF NOT EXISTS users (
	id INT AUTO_INCREMENT PRIMARY KEY, 
	email VARCHAR(255), 
	name VARCHAR(50), 
	password VARCHAR(100), 
	department_id VARCHAR(50), 
	role ENUM('GENERAL', 'ADMIN')
);

/*departmentテーブル作成
*所属部署の情報
CREATE TABLE IF NOT EXISTS departments (
	id INT AUTO_INCREMENT PRIMARY KEY, 
	department_name VARCHAR(50)
);*/

/*attendanceテーブル作成*/
CREATE TABLE IF NOT EXISTS attendance (
	id INT AUTO_INCREMENT PRIMARY KEY, 
	user_id INT, 
	type ENUM('IN', 'OUT', 'BREAK_IN', 'BREAK_OUT'), 
	at DATETIME, 
	FOREIGN KEY (user_id) REFERENCES users(id)
);

/*daily_attendance_summaryテーブル作成
*1日の稼働時間を保持する
*/
CREATE TABLE IF NOT EXISTS daily_attendance_summary (
	id INT AUTO_INCREMENT PRIMARY KEY, 
	user_id INT, 
	work_date DATE, /*勤務日*/
	total_work_time TIME, /*実働時間*/ 
	total_break_time TIME, /*休憩合計時間*/
	is_late BOOLEAN, /*遅刻判定フラグ*/
	is_absent BOOLEAN, /*欠勤判定フラグ*/
	remarks TEXT, 
	FOREIGN KEY (user_id) REFERENCES users(id) 
);

/*repuestsテーブル作成
*打刻修正申請・有給申請のデータ
*/
CREATE TABLE IF NOT EXISTS requests (
	id INT AUTO_INCREMENT PRIMARY KEY, 
	user_id INT, 
	kind ENUM('PAID_LEAVE', 'CORRECTION'), /*有給申請*/
	status ENUM('PENDING', 'APPROVED', 'REJECTED'),/*申請状況*/ 
	target_date DATE, /*対象日（修正・有給）*/
	submitted_at DATETIME,/*提出日時*/ 
	comment TEXT, /*理由・内容*/
	FOREIGN KEY (user_id) REFERENCES users(id)
);

/*approvalsテーブル作成
*承認履歴を管理する
*/
CREATE TABLE IF NOT EXISTS approvals (
	id INT AUTO_INCREMENT PRIMARY KEY, 
	request_id INT, /*申請者id*/
	approver_id INT,/*承認者id*/
	decision ENUM('APPROVED', 'REJECTED'), /*権限管理*/
	decided_at DATETIME, /*承認日*/
	FOREIGN KEY (request_id) REFERENCES requests(id), 
	FOREIGN KEY (approver_id) REFERENCES users(id)
);

/**paidleavesテーブル作成
*付与履歴と有給残数基盤
*/
CREATE TABLE IF NOT EXISTS paidleaves (
	id INT AUTO_INCREMENT PRIMARY KEY, 
	user_id INT, 
	grant_date DATE, /*有給付与した日*/
	revocation_date DATE, /*有給失効する日*/
	days INT, /*有給付与日数*/
	used_days INT, /*使用した日数*/
	FOREIGN KEY (user_id) REFERENCES users(id)
);

/*休日・カレンダー管理*/
CREATE TABLE IF NOT EXISTS holidays (
	date DATE PRIMARY KEY, 
	name VARCHAR(50)/*休日の名前*/
);

