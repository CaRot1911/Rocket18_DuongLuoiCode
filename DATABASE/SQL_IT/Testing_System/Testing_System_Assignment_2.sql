USE accmanager;

# Question 1: lấy ra tất cả các phòng ban
SELECT 
    *
FROM
    department;

# Question 2: lấy ra id của phòng ban có tên là "Sale"
SELECT 
    DepartmentID
FROM
    department
WHERE
    DepartmentName = 'Sales';

# Question 3: lấy ra thông tin account có full name dài nhất
SELECT 
    *
FROM
    account
WHERE
    Username = (SELECT 
            MAX(Username)
        FROM
            account);

# Question 4: Lấy ra tên group đã tham gia trước ngày 20/12/2019
SELECT 
    GroupName
FROM
    `group`
WHERE
    CreateDate < '2019-12-20';

# Lấy ra ID của question có >= 4 câu trả lời
SELECT 
    a.QuestionID, COUNT(a1.Content) AS SUMCONTENT
FROM
    question a
        INNER JOIN
    answer a1 ON a.QuestionID = a1.QuestionID
GROUP BY a.QuestionID;

SELECT 
    a.QuestionID
FROM
    question a
        INNER JOIN
    answer a2 ON a.QuestionID = a2.QuestionID
GROUP BY a.QuestionID
HAVING COUNT(a2.Content) >= 4;

# Lấy ra 5 group được tạo gần đây nhất
SELECT 
    *
FROM
    `group`
WHERE
    CreateDate <= (SELECT 
            MAX(CreateDate)
        FROM
            `group`)
ORDER BY CreateDate DESC
LIMIT 5;

DELETE FROM exam 
WHERE
    CreateDate < '2019-12-20';
 
 # Update thông tin của account có id = 5 thành tên "Nguyễn Bá Lộc" và email thành loc.nguyenba@vti.com.vn
UPDATE account
SET Fullname = N'Nguyễn Bá Lộc', Email = 'loc.nguyenba@vti.com.vn'
WHERE AccountID = 10006;

SELECT 
    *
FROM
    account
WHERE
    AccountID = 10006;

# Vita lệnh để lấy ra danh sách nhân viên và thông tin phòng ban của họ
SELECT 
    a.Fullname, d.DepartmentName
FROM
    account a
        INNER JOIN
    department d ON a.DepartmentID = d.DepartmentID;

# Viết lệnh để lấy ra tất cả các developer
SELECT 
    a.Fullname
FROM
    account a
        INNER JOIN
    position p ON a.PositionID = p.PositionID
WHERE
    p.PositionName = 'Dev';

# Viết lệnh để lấy ra danh sách các phòng ban có >3 nhân viên
SELECT 
    d.DepartmentName, COUNT(a.AccountID)
FROM
    account a
        INNER JOIN
    department d ON a.DepartmentID = d.DepartmentID
GROUP BY d.DepartmentName
ORDER BY COUNT(AccountID) ASC;

SELECT 
    d.DepartmentName
FROM
    account a
        INNER JOIN
    department d ON a.DepartmentID = d.DepartmentID
GROUP BY d.DepartmentName
HAVING COUNT(a.AccountID) > 3;

# Viết lệnh để lấy ra danh sách câu hỏi được sử dụng trong đề thi nhiều nhất

SELECT 
    e.QuestionID, COUNT(e.ExamID) AS 'SUM', q.Content
FROM
    examquestion e
        INNER JOIN
    question q ON e.QuestionID = q.QuestionID
GROUP BY QuestionID
ORDER BY COUNT(ExamID) DESC
LIMIT 3;

# Thông kê mỗi category Question được sử dụng trong bao nhiêu Question
SELECT 
    cq.CategoryID, COUNT(q.QuestionID)
FROM
    categoryquestion cq
        INNER JOIN
    question q ON cq.CategoryID = q.CategoryID
GROUP BY cq.CategoryID
ORDER BY COUNT(q.QuestionID) DESC;

# Lấy ra Question có nhiều câu trả lời nhất
SELECT 
    q.Content, COUNT(a.AnswerID) AS 'SUM'
FROM
    question q
        INNER JOIN
    answer a ON q.QuestionID = a.QuestionID
GROUP BY q.QuestionID
ORDER BY COUNT(a.AnswerID) DESC
LIMIT 1;

# Tìm chức vụ có ít người nhất
SELECT 
    p.PositionID, p.PositionName, COUNT(a.AccountID) AS 'SUM'
FROM
    account a
        INNER JOIN
    position p ON a.PositionID = p.PositionID
GROUP BY p.PositionID , p.PositionName
ORDER BY COUNT(a.AccountID) ASC
LIMIT 1;

# Thống kê mỗi phòng ban có bao nhiêu dev, test, scrum master, PM

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

# Lấy thông tin chi tiết của câu hỏi bao gồm: thông tin cơ bản của question, loại câu hỏi, ai là người tạo ra câu hỏi, câu trả lời là gì,

SELECT 
    q.Content, q.CreatorID, tq.TypeName, a.Content
FROM
    typequestion tq
        INNER JOIN
    question q ON tq.TypeID = q.TypeID
        INNER JOIN
    answer a ON q.QuestionID = a.QuestionID;

# Lấy ra số lượng câu hỏi của mỗi loại tự luận hay trắc nghiệm
SELECT 
    tq.TypeName, COUNT(q.QuestionID)
FROM
    typequestion tq
        INNER JOIN
    question q ON tq.TypeID = q.TypeID
GROUP BY tq.TypeName
ORDER BY COUNT(q.QuestionID);