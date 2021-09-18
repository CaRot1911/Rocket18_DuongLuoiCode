USE sql_noit;

# TRIGGER

# Question 1: Tạo trigger không cho phép người dùng nhập vào Group có ngày tạo trước 1 năm trước
DROP TRIGGER IF EXISTS Input;
DELIMITER $$
CREATE TRIGGER Input
    BEFORE INSERT ON sql_noit.`group`
    FOR EACH ROW
    BEGIN
			DECLARE msg CHAR(20);
            SET msg = 'Error';
        -- Logic
        IF (DATEDIFF(NEW.CreateDate,CURDATE())) > 1
            THEN
            SIGNAL SQLSTATE  '45000'; # Khong duoc nhap
            SET MESSAGE_TEXT = mgs;
        end if;
    end$$
DELIMITER ;

# Question 2: Tạo trigger Không cho phép người dùng thêm bất kỳ user nào vào
# department "Sale" nữa, khi thêm thì hiện ra thông báo "Department
# "Sale" cannot add more user"
DROP TRIGGER IF EXISTS AddUser;
DELIMITER $$
CREATE TRIGGER AddUser
    BEFORE INSERT ON account
    FOR EACH ROW
    BEGIN
        -- Logic
        IF (NEW.DepartmentID = '1')
            THEN
                SIGNAL SQLSTATE  '12345'; # Khong duoc nhap
                SET MESSAGE_TEXT = 'Department "Sale" cannot add more user';
        END IF;
    end$$
DELIMITER ;

# Question 3: Cấu hình 1 group có nhiều nhất là 5 user
DROP TRIGGER IF EXISTS max_user_in_group;
DELIMITER $$
CREATE TRIGGER max_user_in_group
    BEFORE INSERT ON `group`
    FOR EACH ROW
    BEGIN
        -- Logic
            IF (SELECT COUNT(g2.AccountID) FROM `group` g LEFT JOIN groupaccount g2 on g.GroupID = g2.GroupID
            GROUP BY g.GroupID) > 5
                THEN
                SIGNAL SQLSTATE '12345'
                SET MESSAGE_TEXT = 'Group max 5 user';
            end if;

    end$$
DELIMITER ;

# Question 4: Cấu hình 1 bài thi có nhiều nhất là 10 Question
DROP TRIGGER IF EXISTS ExamQues;
DELIMITER $$
CREATE TRIGGER ExamQues
    BEFORE INSERT ON exam
    FOR EACH ROW
    BEGIN
        -- Logic
        IF (SELECT COUNT(eq.QuestionID) FROM exam e LEFT JOIN examquestion eq ON e.ExamID = eq.ExamID
        GROUP BY e.ExamID) > 10
            THEN
                SIGNAL SQLSTATE '12345'
                SET MESSAGE_TEXT = 'Max Question in Exam = 10';
        end if;
    end$$
DELIMITER ;

/*
 Question 5: Tạo trigger không cho phép người dùng xóa tài khoản có email là
admin@gmail.com (đây là tài khoản admin, không cho phép user xóa),
còn lại các tài khoản khác thì sẽ cho phép xóa và sẽ xóa tất cả các thông
tin liên quan tới user đó
*/
DROP TRIGGER IF EXISTS DeletUser;
DELIMITER $$
CREATE TRIGGER DeletUser
    BEFORE DELETE ON account
    FOR EACH ROW
    BEGIN
        IF(OLD.Email = 'admin@gmail.com')
            THEN
                SIGNAL SQLSTATE '12345';
        ELSE
            DELETE FROM account
                WHERE AccountID = OLD.AccountID;
        end if;
    end$$
DELIMITER ;

/*
 Question 6: Không sử dụng cấu hình default cho field DepartmentID của table
Account, hãy tạo trigger cho phép người dùng khi tạo account không điền
vào departmentID thì sẽ được phân vào phòng ban "waiting Department"
*/
DROP TRIGGER IF EXISTS Setup_Acc;
DELIMITER $$
CREATE TRIGGER Setup_Acc
    BEFORE INSERT ON account
    FOR EACH ROW
    BEGIN
        IF(NEW.DepartmentID = NULL)
            THEN
                UPDATE account
                    SET NEW.DepartmentID = 10;
                -- 10 đây là phòng chờ trong csdl
        end if;
    end$$
DELIMITER ;

/*
Question 7: Cấu hình 1 bài thi chỉ cho phép user tạo tối đa 4 answers cho mỗi
question, trong đó có tối đa 2 đáp án đúng.
*/
DROP TRIGGER IF EXISTS Setup_Exam;
DELIMITER $$
CREATE TRIGGER Setup_Exam
    AFTER INSERT ON answer
    FOR EACH ROW
    BEGIN
        DECLARE SumContent INT DEFAULT 0;
        DECLARE SumIsCorrect INT DEFAULT 0;
        SET SumIsCorrect = (SELECT COUNT(isCorrect) FROM answer WHERE IsCorrect = 'T' GROUP BY QuestionID);
        SELECT SumContent = (SELECT COUNT(Content) FROM answer  GROUP BY QuestionID);

        IF(SumContent > 4)
            THEN
                SIGNAL SQLSTATE '12345'
                SET MESSAGE_TEXT = 'Max Content In Question 4';

        end if;
        IF(SumIsCorrect > 2)
            THEN
                SIGNAL SQLSTATE '12345'
                SET MESSAGE_TEXT = 'Max Correct is TRUE 2';
        end if;
    end$$
DELIMITER ;
/*
 Question 8: Viết trigger sửa lại dữ liệu cho đúng:
Nếu người dùng nhập vào gender của account là nam, nữ, chưa xác định
Thì sẽ đổi lại thành M, F, U cho giống với cấu hình ở database
*/
ALTER TABLE account
ADD COLUMN gender CHAR(10);

DROP TRIGGER IF EXISTS UpData;
DELIMITER $$
CREATE TRIGGER UpData
    BEFORE INSERT ON account
    FOR EACH ROW
    BEGIN
        -- Logic
        IF(NEW.gender = 'Male')
            THEN
                UPDATE account
                    SET NEW.gender = 'M';
        ELSEIF(NEW.gender = 'Female')
            THEN
                UPDATE account
                    SET NEW.gender = 'F';
        ELSE
            UPDATE account
                SET NEW.gender = 'U';
        end if;
    end$$
DELIMITER ;

/*
Question 9: Viết trigger không cho phép người dùng xóa bài thi mới tạo được 2 ngày
*/
DROP TRIGGER IF EXISTS Delet;
DELIMITER $$
CREATE TRIGGER Delet
    BEFORE DELETE ON exam
    FOR EACH ROW
    BEGIN
        IF (ROUND(CURDATE(),OLD.CreateDate) = 2)
            THEN
                SIGNAL SQLSTATE '12345'; # Not Delet
        end if;
    end$$
DELIMITER

/*
Question 10: Viết trigger chỉ cho phép người dùng chỉ được update, delete các
question khi question đó chưa nằm trong exam nào
*/
DROP TRIGGER IF EXISTS up_delet_Ques;
DELIMITER $$
CREATE TRIGGER up_delet_Ques
    AFTER UPDATE  ON question
    FOR EACH ROW
    BEGIN
        -- Logic
        DELETE FROM question
            WHERE OLD.QuestionID NOT IN (SELECT eq.QuestionID FROM examquestion eq GROUP BY eq.QuestionID);
        UPDATE question
            SET QuestionID = NEW.QuestionID,Content = NEW.Content, CreatorID = NEW.CreatorID,CategoryID = NEW.CategoryID,TypeID = NEW.TypeID,CreateDate = NEW.CreateDate
        WHERE OLD.QuestionID NOT IN (SELECT eq.QuestionID FROM examquestion eq GROUP BY eq.QuestionID);

    end$$
DELIMITER ;
/*
Question 12: Lấy ra thông tin exam trong đó:

Duration <= 30 thì sẽ đổi thành giá trị "Short time"
30 < Duration <= 60 thì sẽ đổi thành giá trị "Medium time"
Duration > 60 thì sẽ đổi thành giá trị "Long time"
*/
SELECT
               e.ExamID,
               e.Code,
               e.Title,
               CASE
                    WHEN MINUTE(e.Duration) <=30 THEN 'Short time'
                    WHEN 30 < MINUTE(Duration) <= 60 THEN 'Medium time'
                    ELSE 'Long time'
                END AS Duration,
               e.CreatorID,
               e.CreateDate

        FROM exam e;
        
/*
Question 13: Thống kê số account trong mỗi group và in ra thêm 1 column nữa có tên
là the_number_user_amount và mang giá trị được quy định như sau:
    Nếu số lượng user trong group =< 5 thì sẽ có giá trị là few
    Nếu số lượng user trong group <= 20 và > 5 thì sẽ có giá trị là normal
    Nếu số lượng user trong group > 20 thì sẽ có giá trị là higher
*/
SELECT 
    g.GroupID,
    g.GroupName,
    CASE
        WHEN COUNT(a.AccountID) <= 5 THEN 'few'
        WHEN 5 < COUNT(a.AccountID) <= 20 THEN 'normal'
        WHEN COUNT(a.AccountID) > 20 THEN 'higher'
    END AS the_number_user_amount
FROM
    `group` g
        LEFT JOIN
    groupaccount ga ON ga.GroupID = g.GroupID
        LEFT JOIN
    account a ON a.AccountID = ga.AccountID
GROUP BY g.GroupID;

/*
    Question 14: Thống kê số mỗi phòng ban có bao nhiêu user, nếu phòng ban nào
    không có user thì sẽ thay đổi giá trị 0 thành "Không có User"
*/

WITH A AS(SELECT
				d.DepartmentName AS DepName,
				COUNT(a.AccountID) AS SumEMP
			FROM department d
				LEFT  JOIN account a
					on a.DepartmentID = d.DepartmentID
			GROUP BY d.DepartmentName)
SELECT
		a.DepName,
		CASE
			WHEN SumEMP = 0 THEN 'Không có User'
			ELSE SumEMP
			END AS SUMEMP
FROM  A ;
