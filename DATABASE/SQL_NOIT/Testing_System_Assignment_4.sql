USE sql_noit;

# JOIN
# Question 1: Viết lệnh để lấy ra danh sách nhân viên và thông tin phòng ban của họ
SELECT
    a.Fullname, d.DepartmentName
FROM
    account a
        INNER JOIN
    department d ON a.DepartmentID = d.DepartmentID;

# Question 2: Viết lệnh để lấy ra thông tin các account được tạo sau ngày 20/12/2010
SELECT
       *
FROM account a
WHERE a.CreateDate > '2010-12-20';

# Question 3: Viết lệnh để lấy ra tất cả các developer
SELECT
    a.Fullname
FROM
    account a
        INNER JOIN
    position p ON a.PositionID = p.PositionID
WHERE
    p.PositionName = 'Dev';

# Question 4: Viết lệnh để lấy ra danh sách các phòng ban có >3 nhân viên

SELECT
    d.DepartmentName
FROM
    account a
        INNER JOIN
    department d ON a.DepartmentID = d.DepartmentID
GROUP BY d.DepartmentName
HAVING COUNT(a.AccountID) > 3;

# Question 5: Viết lệnh để lấy ra danh sách câu hỏi được sử dụng trong đề thi nhiều nhất

SELECT
    e.QuestionID, COUNT(e.ExamID) AS 'SUM', q.Content
FROM
    examquestion e
        INNER JOIN
    question q ON e.QuestionID = q.QuestionID
GROUP BY QuestionID
ORDER BY COUNT(ExamID) DESC
LIMIT 3;

# Question 6: Thông kê mỗi category Question được sử dụng trong bao nhiêu Question
SELECT
    cq.CategoryID, COUNT(q.QuestionID)
FROM
    categoryquestion cq
        INNER JOIN
    question q ON cq.CategoryID = q.CategoryID
GROUP BY cq.CategoryID
ORDER BY COUNT(q.QuestionID) DESC;

# Question 7: Thông kê mỗi Question được sử dụng trong bao nhiêu Exam
SELECT
       q.QuestionID, SUM(e.ExamID) AS 'SumExam'
FROM question q
    INNER JOIN examquestion e
        on q.QuestionID = e.QuestionID
GROUP BY q.QuestionID
ORDER BY SumExam DESC;

# Question 8: Lấy ra Question có nhiều câu trả lời nhất
SELECT
    q.Content, COUNT(a.AnswerID) AS 'SUM'
FROM
    question q
        INNER JOIN
    answer a ON q.QuestionID = a.QuestionID
GROUP BY q.QuestionID
ORDER BY COUNT(a.AnswerID) DESC
LIMIT 1;

# Question 9: Thống kê số lượng account trong mỗi group
SELECT
       g.GroupID,COUNT(ga.AccountID) AS 'SumAcc'
FROM `group` g
    INNER JOIN groupaccount ga
        ON g.GroupID = ga.GroupID
GROUP BY ga.GroupID
ORDER BY SumAcc DESC;

# Question 10: Tìm chức vụ có ít người nhất
SELECT
    p.PositionID, p.PositionName, COUNT(a.AccountID) AS 'SUM'
FROM
    account a
        INNER JOIN
    position p ON a.PositionID = p.PositionID
GROUP BY p.PositionID , p.PositionName
ORDER BY COUNT(a.AccountID) ASC
LIMIT 1;

# Question 11: Thống kê mỗi phòng ban có bao nhiêu dev, test, scrum master, PM

SELECT
    d.DepartmentName,
    p.PositionName,
    COUNT(a.AccountID) AS 'SUM'
FROM
    department d
        INNER JOIN
    account a ON d.DepartmentID = a.DepartmentID
        INNER JOIN
    position p ON a.PositionID = p.PositionID
GROUP BY d.DepartmentName , p.PositionName
ORDER BY COUNT(a.AccountID) DESC;

# Question 12: Lấy thông tin chi tiết của câu hỏi bao gồm: thông tin cơ bản của question, loại câu hỏi, ai là người tạo ra câu hỏi, câu trả lời là gì, ...
SELECT
    q.Content, q.CreatorID, tq.TypeName, a.Content
FROM
    typequestion tq
        INNER JOIN
    question q ON tq.TypeID = q.TypeID
        INNER JOIN
    answer a ON q.QuestionID = a.QuestionID;

# Question 13: Lấy ra số lượng câu hỏi của mỗi loại tự luận hay trắc nghiệm
SELECT
    tq.TypeName, COUNT(q.QuestionID)
FROM
    typequestion tq
        INNER JOIN
    question q ON tq.TypeID = q.TypeID
GROUP BY tq.TypeName
ORDER BY COUNT(q.QuestionID);

# Question 14:Lấy ra group không có account nào
SELECT
       g.GroupID,g.GroupName
FROM
     `group` g
WHERE g.GroupID NOT IN (SELECT ga.GroupID FROM groupaccount ga GROUP BY ga.GroupID);

# Question 16: Lấy ra question không có answer nào
SELECT
       q.QuestionID,q.Content
FROM
     question q
WHERE q.QuestionID NOT IN (SELECT a.QuestionID FROM answer a  GROUP BY a.QuestionID);

# Union
# Question 17:
SELECT DISTINCT
                C.*
FROM
(SELECT A.* FROM
(SELECT
        a.AccountID,a.Username,a.Email
FROM
     account a
         INNER JOIN groupaccount g
             on a.AccountID = g.AccountID
WHERE g.GroupID = 1) AS A
UNION SELECT
             B.*
FROM
(SELECT
        a.AccountID,a.Username,a.Email
FROM
     account a
         INNER JOIN groupaccount g
             on a.AccountID = g.AccountID
WHERE g.GroupID = 2) as B ) AS C;

# Question 18:
SELECT
       A.*
FROM
(SELECT
       g.GroupID,g.GroupName
FROM `group` g
    INNER JOIN groupaccount g2
        on g.GroupID = g2.GroupID
GROUP BY g.GroupID
HAVING COUNT(g2.AccountID) > 5) AS A

UNION

SELECT
       B.*
FROM
(SELECT
       g.GroupID,g.GroupName
FROM `group` g
    INNER JOIN groupaccount g2
        on g.GroupID = g2.GroupID
GROUP BY g.GroupID
HAVING COUNT(g2.AccountID) < 7) AS B;