USE sql_noit;

USE accmanager;

# Question 2: lấy ra tất cả các phòng ban
SELECT
    *
FROM
    department;

# Question 3: lấy ra id của phòng ban có tên là "Sale"
SELECT
    DepartmentID
FROM
    department
WHERE
    DepartmentName = 'Sales';

# Question 4: lấy ra thông tin account có full name dài nhất
SELECT
    *
FROM
    account
WHERE
    length(Username) = (SELECT
            MAX(length(Username))
        FROM
            account);

# Question 5: Lấy ra thông tin account có full name dài nhất và thuộc phòng ban có id = 3
SELECT
    *
FROM
    account
WHERE
    length(Username) = (SELECT
            MAX(length(Username))
        FROM
            account) AND DepartmentID = 3;


# Question 6: Lấy ra tên group đã tham gia trước ngày 20/12/2019
SELECT
    GroupName
FROM
    `group`
WHERE
    CreateDate < '2019-12-20';

# Question 7: Lấy ra ID của question có >= 4 câu trả lời

SELECT
    a2.QuestionID
FROM
    answer a2
GROUP BY a2.QuestionID
HAVING COUNT(a2.Content) >= 4;

# Question 8: Lấy ra các mã đề thi có thời gian thi >= 60 phút và được tạo trước ngày 20/12/2019
SELECT
       e.Code
FROM
     sql_noit.exam e
WHERE MINUTE(e.Duration) >= 60 AND e.CreateDate < '2019-12-20';


# Question 9: Lấy ra 5 group được tạo gần đây nhất
SELECT
    *
FROM
    `group`
HAVING
    CreateDate <= MAX(CreateDate)
ORDER BY CreateDate DESC
LIMIT 5;

DELETE FROM exam
WHERE
    CreateDate < '2019-12-20';

# Question 10: Đếm số nhân viên thuộc department có id = 2
SELECT
       COUNT(a.AccountID)
FROM
     sql_noit.account a
WHERE a.DepartmentID = 2;

# Question 11: Lấy ra nhân viên có tên bắt đầu bằng chữ "D" và kết thúc bằng chữ "o"
SELECT
       *
FROM
     sql_noit.account a
WHERE a.Fullname LIKE 'D%o';
INSERT INTO sql_noit.account(AccountID, Email, Username, Fullname, DepartmentID, PositionID, CreateDate)
VALUE (10033,'duongo@gamil.com','duongo','Duong o',2,3,'1999-04-30');

# Question 12: Xóa tất cả các exam được tạo trước ngày 20/12/2019
DELETE FROM sql_noit.exam e
WHERE e.CreateDate < '2019-12-20';

#Question 13: Xóa tất cả các question có nội dung bắt đầu bằng từ "câu hỏi"
DELETE FROM sql_noit.question q
WHERE q.Content LIKE 'câu hỏi%';

# Question 14: Update thông tin của account có id = 5 thành tên "Nguyễn Bá Lộc" và email thành loc.nguyenba@vti.com.vn
UPDATE account
SET Fullname = N'Nguyễn Bá Lộc', Email = 'loc.nguyenba@vti.com.vn'
WHERE AccountID = 10006;

#Question 15: update account có id = 5 sẽ thuộc group có id = 4
UPDATE sql_noit.groupaccount ga
SET ga.GroupID = 4
WHERE ga.AccountID = 5;


