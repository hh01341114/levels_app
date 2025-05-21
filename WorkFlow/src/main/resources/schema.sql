
/*usersテーブル作成*/
CREATE TABLE IF NOT EXISTS users (
	id INT AUTO_INCREMENT PRIMARY KEY, 
	email VARCHAR(255), 
	name VARCHAR(50), 
	password VARCHAR(100)
);

/*attendanceテーブル作成*/
CREATE TABLE IF NOT EXISTS attendance (
	id INT AUTO_INCREMENT PRIMARY KEY, 
	user_id INT, 
	type ENUM('IN', 'OUT', 'BREAK_IN', 'BREAK_OUT'), 
	at DATETIME, 
	FOREIGN KEY (user_id) REFERENCES users(id)
);