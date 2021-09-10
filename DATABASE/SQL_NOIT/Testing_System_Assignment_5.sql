USE accmanager;

# Testing_System_Assignment_3

# Tạo view có chứa danh sách nhân viên thuộc phòng ban sale
CREATE OR REPLACE VIEW empSales AS
    SELECT 
        a.AccountID, a.Fullname
    FROM
        account a
            INNER JOIN
        department d ON a.DepartmentID = d.DepartmentID
    WHERE
        d.DepartmentName = 'Sales';
        
SELECT 
    *
FROM
    empSales; # View thông tin nhân viên

# Tạo view có chứa thông tin các account tham gia vào nhiều group nhất
CREATE OR REPLACE VIEW accGroup AS
    SELECT 
        a.AccountID, a.Username, a.Email, COUNT(g.GroupID) AS 'SUM'
    FROM
        account a
            INNER JOIN
        groupaccount g ON a.AccountID = g.AccountID
    GROUP BY a.AccountID
    ORDER BY COUNT(g.GroupID) DESC
    LIMIT 1;

SELECT 
    *
FROM
    accGroup; # View thông tin acc ở trong nhiều group nhất

# Tạo view có chứa câu hỏi có những content quá dài (content quá 300 từ được coi là quá dài) và xóa nó đi
CREATE OR REPLACE VIEW LenghtCTent AS
    SELECT 
        q.QuestionID, q.Content, q.TypeID
    FROM
        question q
    WHERE
        LENGTH(q.Content) > 300;

DELETE FROM question 
WHERE
    LENGTH(Content) > 300; # Xóa những câu hỏi có đọ dài lơn hơn 300 từ

SELECT 
    *
FROM
    LenghtCTent; # View những câu hỏi dài quá 300 từ

# Tạo view có chứa danh sách các phòng ban có nhiều nhân viên nhất
CREATE OR REPLACE VIEW ManagerDep AS
    SELECT 
        d.DepartmentName, COUNT(a.AccountID) AS 'SumEmp'
    FROM
        account a
            INNER JOIN
        department d ON a.DepartmentID = d.DepartmentID
    GROUP BY d.DepartmentName
    ORDER BY COUNT(a.AccountID) DESC
    LIMIT 3;

SELECT 
    *
FROM
    ManagerDep; # View danh sách có nhiều phòng bạn nhất

# Tạo view có chứa tất các các câu hỏi do user họ Nguyễn tạo
CREATE OR REPLACE VIEW CrUSER AS
    SELECT 
        q.QuestionID, q.Content, q.CreateDate, q.TypeID
    FROM
        account a
            INNER JOIN
        question q ON a.AccountID = q.CreatorID
    WHERE
        a.Username LIKE 'Nguyễn%';

SELECT 
    *
FROM
    CrUSER; # View câu hỏi