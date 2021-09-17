USE sql_noit;

/* Question 1: Tạo store để người dùng nhập vào tên phòng ban và in ra tất cả các
 account thuộc phòng ban đó*/

DROP PROCEDURE IF EXISTS InforEmp;
DELIMITER $$
CREATE PROCEDURE InforEmp(IN p_depart CHAR(30))
BEGIN
    SELECT 
    a.AccountID, a.Username, a.Email
FROM
    account a
        JOIN
    department d ON d.DepartmentID = a.DepartmentID
WHERE
    p_depart = d.DepartmentName;
end $$
DELIMITER ;

CALL accmanager.InforEmp('Sales');

/*
 Question 2: Tạo store để in ra số lượng account trong mỗi group
*/
DROP PROCEDURE IF EXISTS accGroup;
DELIMITER $$
CREATE PROCEDURE accGroup(IN p_groupName CHAR(15))
BEGIN
   SELECT 
    COUNT(a.AccountID) AS 'SumAcc'
FROM
    account a
        JOIN
    groupaccount g ON a.AccountID = g.AccountID
        JOIN
    `group` g2 ON g2.GroupID = g.GroupID
WHERE
    p_groupName = g2.GroupName
GROUP BY g2.GroupID;
end $$
DELIMITER ;

CALL accmanager.accGroup('Class1');

/*
 Question 3: Tạo store để thống kê mỗi type question có bao nhiêu question được tạo
trong tháng hiện tại
 */
DROP PROCEDURE IF EXISTS quesMonth;
DELIMITER $$
CREATE PROCEDURE quesMonth(IN p_month INT)
BEGIN
   SELECT 
    tq.TypeName, COUNT(q.QuestionID) AS 'SumQues'
FROM
    question q
        JOIN
    typequestion tq ON q.TypeID = tq.TypeID
WHERE
    MONTH(q.CreateDate) = p_month
GROUP BY tq.TypeName;

end $$
DELIMITER ;

CALL quesMonth(2);

/*
    Question 4: Tạo store để trả ra id của type question có nhiều câu hỏi nhất
 */
DROP PROCEDURE IF EXISTS QuesID;
DELIMITER $$
CREATE PROCEDURE QuesID()
BEGIN
   SELECT 
    A.TypeID
FROM
    (SELECT 
        tq.TypeID, COUNT(q.QuestionID) AS 'SumQues'
    FROM
        question q
    INNER JOIN typequestion tq ON q.TypeID = tq.TypeID
    GROUP BY tq.TypeID) AS A
ORDER BY A.SumQues DESC
LIMIT 1;
end$$
DELIMITER ;

CALL QuesID();

# Question 5: Sử dụng store ở question 4 để tìm ra tên của type question

DROP PROCEDURE IF EXISTS NameQues;
DELIMITER $$
CREATE PROCEDURE NameQues()
BEGIN

  SELECT 
    tq.TypeName
FROM
    typequestion tq
WHERE
    tq.TypeID = (SELECT 
            A.TypeID
        FROM
            (SELECT 
                tq.TypeID, COUNT(q.QuestionID) AS 'SumQues'
            FROM
                question q
            INNER JOIN typequestion tq ON q.TypeID = tq.TypeID
            GROUP BY tq.TypeID) AS A
        ORDER BY A.SumQues DESC
        LIMIT 1);
end$$
DELIMITER ;

CALL NameQues();

/* Question 6: Viết 1 store cho phép người dùng nhập vào 1 chuỗi và trả về group có tên
chứa chuỗi của người dùng nhập vào hoặc trả về user có username chứa
chuỗi của người dùng nhập vào*/
# 1 : Trả về group
# 2 : Trả về username
DROP PROCEDURE IF EXISTS Output;
DELIMITER $$
CREATE PROCEDURE Output(IN p_str CHAR(30),IN p_int TINYINT)
BEGIN
    IF p_int = 1
    THEN
            SELECT g.GroupName FROM `group` g
            WHERE g.GroupName LIKE p_str;
        ELSE
            SELECT a.Username,a.Email,a.Fullname  FROM account a
            WHERE a.Username LIKE p_str;
    end if;
end$$
DELIMITER ;

CALL Output('Class1',1);

/*
Question 7: Viết 1 store cho phép người dùng nhập vào thông tin fullName, email và
trong store sẽ tự động gán:

username sẽ giống email nhưng bỏ phần @..mail đi
positionID: sẽ có default là developer
departmentID: sẽ được cho vào 1 phòng chờ

Sau đó in ra kết quả tạo thành công
 */
DROP PROCEDURE IF EXISTS Success;
DELIMITER $$
CREATE PROCEDURE Success(IN p_fullname CHAR(30),IN p_email CHAR(40))
BEGIN
    UPDATE account a
    SET a.DepartmentID = 10,
        a.PositionID = 1
    WHERE p_fullname = a.Fullname AND
          p_email = a.Email AND
          a.Username = SUBSTRING_INDEX(a.Email, '@', 1);
    SET @Print = 'Success';
    SELECT @Print;

end$$
DELIMITER ;
SELECT  SUBSTRING_INDEX(Email,'@',1) FROM account;
/* Question 8: Viết 1 store cho phép người dùng nhập vào Essay hoặc Multiple-Choice
để thống kê câu hỏi essay hoặc multiple-choice nào có content dài nhất */

DROP PROCEDURE IF EXISTS Statistical;
DELIMITER $$
CREATE PROCEDURE Statistical(IN p_typeName CHAR(20))
BEGIN
    SELECT 
    q.Content
FROM
    typequestion tq
        INNER JOIN
    question q ON tq.TypeID = q.TypeID
WHERE
    p_typeName = tq.TypeName
        AND LENGTH(q.Content)
ORDER BY LENGTH(q.Content) DESC
LIMIT 1;
end$$
DELIMITER ;

CALL  Statistical('Multiple-Choice');

# Question 9: Viết 1 store cho phép người dùng xóa exam dựa vào ID
DROP PROCEDURE IF EXISTS Delet;
DELIMITER $$
CREATE PROCEDURE Delet(IN p_ID INT)
BEGIN
    DELETE FROM exam e
    WHERE p_ID = e.ExamID;
end$$
DELIMITER ;

CALL Delet('1');

/*
Question 10: Tìm ra các exam được tạo từ 3 năm trước và xóa các exam đó đi (sử
dụng store ở câu 9 để xóa)
Sau đó in số lượng record đã remove từ các table liên quan trong khi
removing
 */
DROP PROCEDURE IF EXISTS CrExam;
DELIMITER $$
CREATE PROCEDURE CrExam(OUT p_SumQues INT)
BEGIN
    /*SELECT COUNT(e.ExamID) AS SumQues FROM exam e
    WHERE  ROUND((DATEDIFF(CURDATE(),e.CreateDate)/365),1) >= 3;
    DELETE FROM exam e
    WHERE  ROUND((DATEDIFF(CURDATE(),e.CreateDate)/365),1) >= 3;*/
    SELECT 
    COUNT(e.ExamID)
INTO p_SumQues FROM
    exam e
WHERE
    ROUND((DATEDIFF(CURDATE(), e.CreateDate) / 365),
            1) >= 3;
    DELETE FROM exam e
    WHERE  ROUND((DATEDIFF(CURDATE(),e.CreateDate)/365),1) >= 3;
    /*WHILE i < p_SumQues DO
            CALL Delet((SELECT e.ExamID FROM exam e WHERE  ROUND((DATEDIFF(CURDATE(),e.CreateDate)/365),1) >= 3)); # ERROR : SubQuery than 1 row
            SET i = i + 1;
    end while;*/
END$$
DELIMITER ;

CALL CrExam();
CALL Delet('CrExam()');
INSERT INTO exam
VALUE
(11,'NET004','.NET',3,'00:35:00',10004,'1998-06-24'),
(12,'RUBY001','RUBY',3,'00:35:00',10004,'1997-08-24');
SELECT * FROM exam;

/*
 Question 11: Viết store cho phép người dùng xóa phòng ban bằng cách người dùng
nhập vào tên phòng ban và các account thuộc phòng ban đó sẽ được
chuyển về phòng ban default là phòng ban chờ việc
*/
DROP PROCEDURE IF EXISTS DeletDep;
DELIMITER $$
CREATE PROCEDURE DeletDep(IN p_depName CHAR(30))
BEGIN
        UPDATE account a JOIN department d ON d.DepartmentID = a.DepartmentID
            SET a.DepartmentID = 10
        WHERE d.DepartmentName = p_depName;

    DELETE
    FROM department
    WHERE DepartmentName = p_depName;
end$$
DELIMITER ;

/*
  Question 12: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong năm
nay
*/
DROP PROCEDURE IF EXISTS QuesInYears;
DELIMITER $$
CREATE PROCEDURE QuesInYears()
BEGIN
    SELECT MonInYear.MONTH, COUNT(q.QuestionID) AS 'Quantity'
    FROM (SELECT 1 AS MONTH
          UNION
          SELECT 2 AS MONTH
          UNION
          SELECT 3 AS MONTH
          UNION
          SELECT 4 AS MONTH
          UNION
          SELECT 5 AS MONTH
          UNION
          SELECT 6 AS MONTH
          UNION
          SELECT 7 AS MONTH
          UNION
          SELECT 8 AS MONTH
          UNION
          SELECT 9 AS MONTH
          UNION
          SELECT 10 AS MONTH
          UNION
          SELECT 11 AS MONTH
          UNION
          SELECT 12 AS MONTH) AS MonInYear
             LEFT JOIN question q ON MONTH(q.CreateDate) = MonInYear.MONTH
    GROUP BY MonInYear.MONTH
    ORDER BY MonInYear.MONTH;
end$$
DELIMITER ;


/*
 Question 13: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong 6
tháng gần đây nhất
(Nếu tháng nào không có thì sẽ in ra là "không có câu hỏi nào trong
tháng")
*/
DROP PROCEDURE IF EXISTS QuesInYears6;
DELIMITER $$
CREATE PROCEDURE QuesInYears6()
BEGIN
    SELECT MonInYear.MONTH, COUNT(q.QuestionID) AS 'Quantity'
    FROM (SELECT 1 AS MONTH
          UNION
          SELECT 2 AS MONTH
          UNION
          SELECT 3 AS MONTHm
          UNION
          SELECT 4 AS MONTH
          UNION
          SELECT 5 AS MONTH
          UNION
          SELECT 6 AS MONTH
          UNION
          SELECT 7 AS MONTH
          UNION
          SELECT 8 AS MONTH
          UNION
          SELECT 9 AS MONTH
          UNION
          SELECT 10 AS MONTH
          UNION
          SELECT 11 AS MONTH
          UNION
          SELECT 12 AS MONTH) AS MonInYear
             LEFT JOIN question q ON MONTH(q.CreateDate) = MonInYear.MONTH
    WHERE ((MONTH(CURDATE()) - MONTH) BETWEEN 1 AND 6)
    GROUP BY MonInYear.MONTH
    ORDER BY MonInYear.MONTH;
end$$
DELIMITER ;