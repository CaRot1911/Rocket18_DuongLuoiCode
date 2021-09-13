DROP DATABASE IF EXISTS Data_emp;
CREATE DATABASE Data_emp;

USE Data_emp;

/*
 Question 1: Tạo table với các ràng buộc và kiểu dữ liệu
*/
CREATE TABLE Department(
    Department_Number 	TINYINT AUTO_INCREMENT 			NOT NULL ,
    Department_Name 	ENUM('Dev','Maketing','Sales') 	NOT NULL ,
    PRIMARY KEY (Department_Number)
);

CREATE TABLE Employee_Table(
    Employee_Number 	TINYINT 	NOT NULL AUTO_INCREMENT,
    Employee_Name 		CHAR(30) 	NOT NULL ,
    Department_Number 	TINYINT 	NOT NULL ,
    PRIMARY KEY (Employee_Number),
    FOREIGN KEY (Department_Number) REFERENCES Department(Department_Number)
);

CREATE TABLE Employee_Skill_Table (
    Employee_Number 	TINYINT 	NOT NULL ,
    Skill_Code 			CHAR(30) 	NOT NULL ,
    Date_Registered 	DATE 		NOT NULL ,
    FOREIGN KEY (Employee_Number) REFERENCES Employee_Table(Employee_Number)
);

/*
    Question 2: Thêm ít nhất 10 bản ghi vào table
*/

# Table Department
INSERT INTO Department(Department_Name)
VALUE
('Dev'),
('Maketing'),
('Sales');
SELECT * FROM Department;

# Table Employee_Table
INSERT INTO Employee_Table(Employee_Name, Department_Number)
VALUE
('Alex',1),
('Logan',1),
('Ant Man',1),
('Thor',2),
('Joker',3),
('Super Man',3),
('Iron Man',3),
('Hub',2),
('Captain America',1),
('Harry Queen',1);
SELECT * FROM Employee_Table;

# Table Employee_Skill_Table
INSERT INTO Employee_Skill_Table
VALUE
(1,'Java','1999-12-23'),
(10,'Java','2017-12-23'),
(9,'.NET','2016-09-22'),
(9,'Java','2000-06-15'),
(9,'Python','2018-7-21'),
(3,'Java','2019-2-23'),
(2,'Java','1999-12-23'),
(1,'Python','2000-12-02'),
(1,'Ruby','2010-11-23');
SELECT * FROM Employee_Skill_Table;

/*
Question 3: Viết lệnh để lấy ra danh sách nhân viên (name) có skill Java
Hướng dẫn: sử dụng UNION
*/

SELECT 
    *
FROM
    Employee_Table emp
        INNER JOIN
    Employee_Skill_Table EST ON emp.Employee_Number = EST.Employee_Number
WHERE
    EST.Skill_Code = 'Java';

/*
    Question 4: Viết lệnh để lấy ra danh sách các phòng ban có >3 nhân viên
*/
SELECT DISTINCT
    d.Department_Number, d.Department_Name
FROM
    Department d
        JOIN
    Employee_Table ET ON d.Department_Number = ET.Department_Number
HAVING COUNT(ET.Employee_Number) > 3;

/*
Question 5: Viết lệnh để lấy ra danh sách nhân viên của mỗi văn phòng ban.
Hướng dẫn: sử dụng GROUP BY
*/
SELECT 
    ET.Employee_Number, ET.Employee_Name, d.Department_Name
FROM
    Department d
        JOIN
    Employee_Table ET ON d.Department_Number = ET.Department_Number
GROUP BY ET.Employee_Number , ET.Department_Number;
#GROUP BY d.Department_Name;

/*
Question 6: Viết lệnh để lấy ra danh sách nhân viên có > 1 skills.

Hướng dẫn: sử dụng DISTINCT
*/

SELECT DISTINCT
    emp.Employee_Number, emp.Employee_Name
FROM
    employee_table emp
        JOIN
    Employee_Skill_Table EST ON emp.Employee_Number = EST.Employee_Number
GROUP BY emp.Employee_Number , emp.Employee_Name
HAVING COUNT(EST.Employee_Number) > 1;