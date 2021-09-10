USE  freshermanager;

# Question 1: Thêm ít nhất 10 bản ghi vào table
INSERT INTO trainee(TraineeID,Full_Name, Birth_Date, Gender, ET_IQ, ET_Gmath, ET_English, Training_Class, Evaluation_Notes,VTI_Account)
VALUES
(1,'Nguyen Tan Tai','1998-09-22','male',15,12,30,1,'','tantai'),
(2,'Nguyen Van Tuan','1999-02-19','male',19,10,30,2,'','vantuan'),
(3,'Nguyen Manh Dung','2001-01-12','male',16,15,35,1,'','manhdung'),
(4,'Nguyen Thi Thuy','1997-04-30','female',20,19,45,4,'Good','thuynguyen'),
(5,'Nguyen Thu Thuy','1998-04-28','female',19,18,29,4,'','thuthuy'),
(6,'Nguyen Van Huy','2002-05-31','male',18,18,35,6,'','huynguyen'),
(7,'Nguyen Huy Hoang','2001-09-21','male',17,18,37,7,'','huyhoang'),
(8,'Nguyen Manh Tu','2001-10-12','male',9,10,25,10,'','manhtu'),
(9,'Nguyen Huy Hung','1999-06-24','male',15,12,30,2,'','huyhung'),
(10,'Phan Tan Trung','1996-02-14','male',15,12,30,2,'','tantrung');

SELECT 
    *
FROM
    trainee;
COMMIT ;
/*Question 2: Viết lệnh để lấy ra tất cả các thực tập sinh đã vượt qua bài test đầu vào,
nhóm chúng thành các tháng sinh khác nhau */

# ET_Gmath >= 15 steep
SELECT 
    t.TraineeID, t.Full_Name, t.Gender, MONTH(t.Birth_Date)
FROM
    trainee t
WHERE
    t.ET_Gmath >= 15
ORDER BY MONTH(t.Birth_Date);

/*Question 3: Viết lệnh để lấy ra thực tập sinh có tên dài nhất, lấy ra các thông tin sau:
 tên, tuổi, các thông tin cơ bản (như đã được định Inga trong table)*/
SELECT 
    t.TraineeID,
    t.Full_Name,
    t.Birth_Date,
    t.Gender,
    t.ET_Gmath,
    t.ET_English,
    t.ET_IQ,
    t.VTI_Account
FROM
    trainee t
WHERE
    LENGTH(t.Full_Name) = (SELECT 
            MAX(LENGTH(t2.Full_Name))
        FROM
            trainee t2);

/*Question 4: Viết lệnh để lấy ra tất cả các thực tập sinh là ET, 1 ET thực tập sinh là
những người đã vượt qua bài test đầu vào và thỏa mãn số điểm như sau:
 ET_IQ + ET_Gmath>=20
 ET_IQ>=8
 ET_Gmath>=8
 ET_English>=18
 */
SELECT 
    *
FROM
    trainee t
WHERE
    (t.ET_IQ + t.ET_Gmath) >= 20
        AND t.ET_IQ >= 8
        AND t.ET_Gmath >= 8
        AND t.ET_English >= 18;

/*
    Question 5: xóa thực tập sinh có TraineeID = 3
*/

DELETE FROM trainee 
WHERE
    TraineeID = 3;
SELECT 
    *
FROM
    trainee;

/*
    Question 6: Thực tập sinh có TraineeID = 5 được chuyển sang lớp "2". Hãy cập nhật
thông tin vào database
*/

UPDATE trainee t 
SET 
    t.Training_Class = '2'
WHERE
    t.TraineeID = 5;
SELECT 
    *
FROM
    trainee;
