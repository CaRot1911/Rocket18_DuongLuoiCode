DROP DATABASE IF EXISTS accmanager;
CREATE DATABASE accmanager;

USE accmanager;
DROP TABLE IF EXISTS Department,Position,Account,`Group`,GroupAccount,TypeQuestion,CategoryQuestion,Question,Answer,Exam,ExamQuestion;
# Create table
CREATE TABLE Department (
    DepartmentID 	TINYINT AUTO_INCREMENT 	NOT NULL,	#định danh của phòng ban
    DepartmentName 	CHAR(30)				NOT NULL,	#tên đầy đủ của phòng ban
    PRIMARY KEY (DepartmentID)
);

CREATE TABLE Position (
    PositionID 		TINYINT AUTO_INCREMENT NOT NULL,	#định danh của chức vụ
    PositionName	ENUM('Dev','Test','Scrum Master','PM')  				NOT NULL,	#tên chức vụ
    PRIMARY KEY (PositionID)
);

CREATE TABLE Account (
    AccountID 		SMALLINT AUTO_INCREMENT NOT NULL,	#định danh của User
    Email 			CHAR(40) 				NOT NULL,
    Username 		CHAR(30) 				NOT NULL,
    Fullname 		CHAR(30) 				NOT NULL,
    DepartmentID 	TINYINT 				NOT NULL,	#phòng ban của user trong hệ thống
    PositionID 		TINYINT 				NOT NULL,	#chức vụ của User
    CreateDate 		DATE					NOT NULL,	#ngày tạo tài khoản
    PRIMARY KEY (AccountID),
    FOREIGN KEY (DepartmentID)		REFERENCES Department (DepartmentID),
    FOREIGN KEY (PositionID)		REFERENCES Position (PositionID)
);

CREATE TABLE `Group` (
    GroupID 		SMALLINT AUTO_INCREMENT NOT NULL,	#định danh của nhóm
    GroupName 		CHAR(20) 				NOT NULL,	#tên nhóm
    CreatorID 		SMALLINT 				NOT NULL,	#id của người tạo group
    CreateDate 		DATE 					NOT NULL,	#ngày tạo group
    PRIMARY KEY (GroupID)
);

CREATE TABLE GroupAccount (
    GroupID 	SMALLINT NOT NULL,	#định danh của nhóm
    AccountID 	SMALLINT NOT NULL,	#định danh của User
    JoinDate 	DATE NOT NULL,	#Ngày user tham gia vào nhóm
    FOREIGN KEY (GroupID)		REFERENCES `Group` (GroupID),
    FOREIGN KEY (AccountID)		REFERENCES Account (AccountID),
    PRIMARY KEY (GroupID,AccountID)
);

CREATE TABLE TypeQuestion (
    TypeID 		SMALLINT AUTO_INCREMENT NOT NULL,	#định danh của loại câu hỏi
    TypeName 	ENUM('Essay','Multiple-Choice') 				NOT NULL,	#tên của loại câu hỏi
    PRIMARY KEY (TypeID)
);

CREATE TABLE CategoryQuestion (
    CategoryID 		SMALLINT AUTO_INCREMENT NOT NULL,	#định danh của chủ đề câu hỏi
    CategoryName 	CHAR(20) 				NOT NULL,	#tên của chủ đề câu hỏi
    PRIMARY KEY (CategoryID)
);

CREATE TABLE Question (
    QuestionID 	SMALLINT AUTO_INCREMENT NOT NULL,	#định danh của câu hỏi
    Content 	TEXT 					NOT NULL,	#nội dung của câu hỏi
    CategoryID 	SMALLINT 				NOT NULL,	#định danh của chủ đề câu hỏi
    TypeID 		SMALLINT 				NOT NULL,	#định danh của loại câu hỏi
    CreatorID 	SMALLINT 				NOT NULL,	#id của người tạo câu hỏi
    CreateDate 	DATE 					NOT NULL,	#ngày tạo câu hỏi
    PRIMARY KEY (QuestionID),
    FOREIGN KEY (CategoryID)		REFERENCES CategoryQuestion (CategoryID),
    FOREIGN KEY (TypeID)			REFERENCES TypeQuestion (TypeID),
    FOREIGN KEY (CreatorID)			REFERENCES Account(AccountID)
);

CREATE TABLE Answer (
    AnswerID 	SMALLINT AUTO_INCREMENT NOT NULL,	#định danh của câu trả lời
    Content 	TEXT 					NOT NULL,	#nội dung của câu trả lời
    QuestionID 	SMALLINT 				NOT NULL,	#định danh của câu hỏi
    isCorrect 	ENUM('T', 'F') 			NOT NULL,	#câu trả lời này đúng hay sai
    PRIMARY KEY (AnswerID),
    FOREIGN KEY (QuestionID)		REFERENCES Question (QuestionID)
);

CREATE TABLE Exam (
    ExamID 		SMALLINT AUTO_INCREMENT NOT NULL,	#định danh của đề thi
    Code 		CHAR(10) 				NOT NULL,	#mã đề thi
    Title 		CHAR(30) 				NOT NULL,	#tiêu đề của đề thi
    CategoryID 	SMALLINT 				NOT NULL,	#định danh của chủ đề thi
    Duration 	CHAR(20) 				NOT NULL,	#thời gian thi
    CreatorID 	SMALLINT 				NOT NULL,	#id của người tạo đề thi
    CreateDate 	DATE 					NOT NULL,	#ngày tạo đề thi
    PRIMARY KEY (ExamID),
    FOREIGN KEY (CategoryID)		REFERENCES CategoryQuestion (CategoryID),
    FOREIGN KEY (CreatorID)			REFERENCES Account(AccountID)
);

CREATE TABLE ExamQuestion (
    ExamID 		SMALLINT NOT NULL,	#định danh của đề thi
    QuestionID 	SMALLINT NOT NULL,	#định danh của câu hỏi
    FOREIGN KEY (ExamID)		REFERENCES Exam (ExamID),
    FOREIGN KEY (QuestionID)	REFERENCES Question (QuestionID)
);


# Insert

# Table Department
INSERT INTO Department(DepartmentName)
VALUE
('Sales'),
('Maketing'),
('Customer Service'),
('Development'),
('Finance'),
('Human Resources'),
('Production'),
('Quality Management'),
('Research');
# SELECT * FROM Department;

# Table Position
INSERT Position
VALUE (1,'Dev'),(2,'Test'),(3,'Scrum Master'),(4,'PM');
# SELECT * FROM Position;

# Table Account
INSERT INTO Account(AccountID,Email, Username, Fullname, DepartmentID, PositionID, CreateDate)
VALUE
(10002,'simmel@gmail.com','bezalelsimmel','Bezalel Simmel',1,'4','1986-08-28'),
(10003,'bamford@gmail.com','partobamford','Parto Bamford',1,4,'1986-08-28'),
(10004,'koblick@gmail.com','chirstiankoblick','Chirstian Koblick',1,4,'1986-12-01'),
(10005,'maliniak@gmail.com','kyoichimaliniak','Kyoichi Maliniak',1,4,'1989-09-12'),
(10006,'preusig@gmail.com','annekepreusig','Anneke Preusig',1,4,'1989-06-02'),
(10007,'tzvetanzielinski@gmail.com','tzvetanzielinski','Tzvetan Zielinski',2,1,'1989-02-10'),
(10008,'saniyakalloufi@gmail.com','saniyakalloufi','Saniya Kalloufi',2,1,'1994-09-15'),
(10009,'sumantpeac@gmail.com','sumantpeac','Sumant Peac',2,2,'1985-02-18'),
(10010,'duangkaewpiveteau@gmail.com','duangkaewpiveteau','Duangkaew Piveteau',2,3,'1989-08-24'),
(10011,'marysluis@gmail.com','marysluis','Mary Sluis',2,1,'1990-01-22'),
(10012,'patriciobridgland@gmail.com','patriciobridgland','Patricio Bridgland',2,1,'1992-12-18'),
(10013,'eberhardtterkki@gmail.com','eberhardtterkki','Eberhardt Terkki',2,1,'1985-10-20'),
(10014,'bernigenin@gmail.com','bernigenin','Berni Genin',2,3,'1987-03-11'),
(10015,'guoxiangnooteboom@gmail.com','guoxiangnooteboom','Guoxiang Nooteboom',2,3,'1987-07-02'),
(10016,'kazuhitocappelletti@gmail.com','kazuhitocappelletti','Kazuhito Cappelletti',2,4,'1995-01-27'),
(10017,'cristinelbouloucos@gmail.com','cristinelbouloucos','Cristinel Bouloucos',2,1,'1993-08-03'),
(10018,'kazuhidepeha@gmail.com','kazuhidepeha','Kazuhide Peha',2,3,'1987-04-03'),
(10019,'lillianhaddadi@gmail.com','lillianhaddadi','Lillian Haddadi',2,2,'1999-04-30'),
(10020,'mayukowarwick@gmail.com','mayukowarwick','Mayuko Warwick',2,2,'1991-01-26'),
(10021,'ramzierde@gmail.com','ramzierde','Ramzi Erde',4,1,'1988-02-10'),
(10022,'shahaffamili@gmail.com','shahaffamili','Shahaf Famili',4,1,'1995-08-22'),
(10023,'bojanmontemayor@gmail.com','bojanmontemayor','Bojan Montemayor',4,1,'1989-12-17'),
(10024,'suzettepettey@gmail.com','suzettepettey','Suzette Pettey',4,1,'1997-05-19'),
(10025,'prasadramheyers@gmail.com','prasadramheyers','Prasadram Heyers',4,4,'1987-08-17'),
(10026,'yongqiaoberztiss@gmail.com','yongqiaoberztiss','Yongqiao Berztiss',4,2,'1995-03-20'),
(10027,'divierreistad@gmail.com','divierreistad','Divier Reistad',4,2,'1989-07-07'),
(10028,'domenicktempesti@gmail.com','domenicktempesti','Domenick Tempesti',4,1,'1991-10-22'),
(10029,'otmarherbst@gmail.com','otmarherbst','Otmar Herbst',4,1,'1985-11-20'),
(10030,'elvisdemeyer@gmail.com','elvisdemeyer','Elvis Demeyer',6,4,'1994-02-17'),
(10031,'karstenjoslin@gmail.com','karstenjoslin','Karsten Joslin',5,4,'1991-09-01'),
(10032,'jeongreistad@gmail.com','jeongreistad','Jeong Reistad',6,3,'1990-06-20');
# SELECT * FROM Account;

# Table Group
INSERT INTO `Group`
VALUE
(1,'Class1',10030,'2018-12-09'),
(2,'Class2',10031,'1994-02-17'),
(3,'Class3',10025,'2018-12-09'),
(4,'Class4',10032,'1991-09-01'),
(5,'Class5',10018,'1985-06-27'),
(6,'Class6',10020,'2019-11-19'),
(7,'Class7',10030,'2017-12-20'),
(8,'Class8',10030,'2020-12-09'),
(9,'Class9',10031,'2021-12-09'),
(10,'Class10',10025,'2020-04-20'),
(11,'Class11',10025,'2021-11-11');

# SELECT * FROM `Group`;

# Table GroupAccount
INSERT INTO GroupAccount()
VALUE
(1,10028,'2018-12-21'),
(1,10022,'2019-03-03'),
(1,10029,'2019-12-21'),
(1,10030,'2020-12-21'),
(1,10012,'2018-12-23'),
(1,10010,'2018-12-25'),
(1,10032,'2018-12-24'),
(1,10021,'2019-01-20'),
(1,10003,'2019-01-05'),
(1,10002,'2019-10-01'),
(2,10032,'1994-03-17'),
(2,10003,'1994-07-05'),
(2,10004,'1994-08-05'),
(2,10005,'1994-07-05'),
(3,10020,'2018-12-09'),
(3,10022,'2018-01-05'),
(3,10028,'2019-01-05'),
(3,10029,'2018-12-12'),
(11,10007,'2021-11-11'),
(11,10008,'2021-11-12'),
(11,10009,'2021-11-21'),
(11,10011,'2021-12-21'),
(7,10015,'2017-12-20'),
(7,10017,'2017-12-21'),
(7,10016,'2017-12-21'),
(7,10019,'2018-01-05'),
(8,10021,'2020-12-09'),
(8,10029,'2021-12-12'),
(8,10020,'2021-11-12'),
(8,10022,'2020-12-12'),
(8,10011,'2021-12-24');

# SELECT * FROM groupaccount;

# Table TypeQuestion
INSERT INTO typequestion()
VALUE
(1,'Essay'),
(2,'Multiple-Choice');
SELECT * FROM typequestion;
# Table CategoryQuestion
INSERT INTO CategoryQuestion()
VALUE
(1,'Java'),
(2,'Ruby'),
(3,'.NET'),
(4,'Python'),
(5,'SQL'),
(6,'C/C++'),
(7,'JS'),
(8,'HTML'),
(9,'CSS'),
(10,'PHP');

# Table Question
INSERT INTO Question()
VALUE
(1,'sadasd',1,1,10002,'2020-01-15'),
(2,'sadasd',1,2,10021,'2021-07-15'),
(3,'sadasd',1,1,10022,'2020-03-5'),
(4,'sadasd',1,2,10009,'2020-01-15'),
(5,'sadasd',1,1,10010,'2020-01-15'),
(6,'sadasd',1,1,10021,'2019-12-15'),
(7,'sadasd',2,1,10021,'2020-12-15'),
(8,'sadasd',2,2,10011,'2018-08-15'),
(9,'sadasd',2,1,10030,'2020-03-15'),
(10,'sadasd',2,1,10031,'2020-04-15'),
(11,'sadasd',2,1,10032,'2020-02-23'),
(12,'sadasd',3,1,10030,'2020-02-18'),
(13,'sadasd',3,1,10005,'2021-12-15'),
(14,'sadasd',3,2,10005,'2019-12-28'),
(15,'sadasd',3,2,10008,'2020-01-30'),
(16,'sadasd',3,2,10010,'2020-02-15'),
(17,'sadasd',3,1,10015,'2020-05-15'),
(18,'sadasd',4,1,10025,'2020-09-15'),
(19,'sadasd',4,1,10023,'2020-11-15'),
(20,'sadasd',4,1,10021,'2020-12-15'),
(21,'sadasd',4,1,10024,'2020-11-15');

# SELECT * FROM Question;
# Table Answer
INSERT INTO Answer()
VALUE
(1,'adaafwrweasd',1,'T'),
(2,'adaafwrweasd',1,'F'),
(3,'adaafwrweasd',1,'T'),
(4,'adaafwrweasd',1,'T'),
(5,'adaafwrweasd',1,'T'),
(6,'adaafwrweasd',1,'F'),
(7,'adaafwrweasd',2,'T'),
(8,'adaafwrweasd',2,'T'),
(9,'adaafwrweasd',2,'T'),
(10,'adaafwrweasd',3,'F'),
(11,'adaafwrweasd',3,'F'),
(12,'adaafwrweasd',3,'F'),
(13,'adaafwrweasd',4,'T'),
(14,'adaafwrweasd',4,'T'),
(15,'adaafwrweasd',4,'F'),
(16,'adaafwrweasd',5,'T'),
(17,'adaafwrweasd',5,'T'),
(18,'adaafwrweasd',6,'F'),
(19,'adaafwrweasd',6,'F'),
(20,'adaafwrweasd',6,'F'),
(21,'adaafwrweasd',6,'T'),
(22,'adaafwrweasd',7,'T'),
(23,'adaafwrweasd',6,'T');

# SELECT * FROM Answer;
# Table Exam
INSERT INTO Exam()
VALUE
(1,'JV001','JAVA CORE',1,'15 MINUTE',10023,'2020-06-24'),
(2,'JV002','JAVA CORE',1,'15 MINUTE',10025,'2020-06-24'),
(3,'JV003','JAVA CORE',1,'15 MINUTE',10023,'2020-06-24'),
(4,'SQL001','DATA BASE',5,'45 MINUTE',10004,'2020-07-24'),
(5,'SQL002','DATA BASE',5,'30 MINUTE',10004,'2020-07-24'),
(6,'SQL003','DATA BASE',5,'15 MINUTE',10004,'2020-08-22'),
(7,'SQL004','DATA BASE',5,'15 MINUTE',10004,'2020-08-22'),
(8,'SQL005','DATA BASE',5,'15 MINUTE',10004,'2020-09-01'),
(9,'NET001','.NET',3,'15 MINUTE',10004,'2020-06-24'),
(10,'NET001','.NET',3,'35 MINUTE',10004,'2020-06-24');

# SELECT * FROM Exam;
# TABLE ExamQuestion
INSERT INTO ExamQuestion()
VALUE
(1,1),
(1,2),
(1,1),
(1,3),
(1,1),
(1,1),
(1,1),
(1,4),
(1,4),
(2,1),
(2,1),
(2,2),
(2,3),
(3,4),
(3,3),
(1,1),
(1,1),
(1,1),
(1,1);

# SELECT * FROM ExamQuestion;