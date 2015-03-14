DROP TABLE IF EXISTS Assignment;
CREATE TABLE Assignment (
	id INT AUTO_INCREMENT PRIMARY KEY,
	student_id INT NOT NULL,
	student_name VARCHAR(255) NOT NULL,
	assignment_id INT NOT NULL,
	assignment_grade decimal NOT NULL,
	UNIQUE(student_id, assignment_id)
);