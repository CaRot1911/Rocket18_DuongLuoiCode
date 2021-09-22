DROP DATABASE IF EXISTS ThucTap;
CREATE DATABASE ThucTap;

USE ThucTap;

DROP TABLE IF EXISTS GiangVien,SinhVien,DeTai,HuongDan;

CREATE TABLE GiangVien(
    magv    CHAR(9)         NOT NULL ,
    hoten   VARCHAR(30)     NOT NULL ,
    luong   DECIMAL(10,2)   NOT NULL ,
    PRIMARY KEY (magv)
);

CREATE TABLE SinhVien(
    masv    CHAR(9)     NOT NULL ,
    hoten   VARCHAR(30) NOT NULL ,
    namsinh DATE        NOT NULL ,
    quequan VARCHAR(30) NOT NULL,
    PRIMARY KEY (masv)
);

CREATE TABLE DeTai(
    madt        TINYINT         NOT NULL AUTO_INCREMENT ,
    tendt       VARCHAR(30)     NOT NULL ,
    kinhphi     DECIMAL(10,2)   NOT NULL ,
    NoiThucTap  TEXT            NOT NULL ,
    PRIMARY KEY (madt)
);

/*
    0 : Hoàn Thiện
    1 : Chưa Hoàn Thiện
    2 : Đang tiến hành kiểm thử
*/
CREATE TABLE HuongDan(
    id      TINYINT             NOT NULL AUTO_INCREMENT ,
    masv    CHAR(9)             NOT NULL ,
    madt    TINYINT             NOT NULL ,
    magv    CHAR(9)             NOT NULL ,
    ketqua  ENUM('0','1')       NOT NULL ,
    PRIMARY KEY (id) ,
    FOREIGN KEY (masv) REFERENCES SinhVien(masv) ON DELETE CASCADE ,
    FOREIGN KEY (madt) REFERENCES DeTai(madt),
    FOREIGN KEY (magv) REFERENCES GiangVien(magv)
);

INSERT INTO GiangVien(magv, hoten, luong)
VALUES ('GV1911999','Nguyễn Văn Cỗi',5000000) ,
       ('GV1912000','Nguyễn Mạnh Dũng',6500000) ,
       ('GV1912001','Nguyễn Thúy Hằng',4500000) ,
       ('GV1912002','Nguyễn Duy Mạnh',4000000) ,
       ('GV1912003','Phan Tấn Trung',5000000) ,
       ('GV1912004','Nguyễn Thành Đạt',7000000) ;

INSERT INTO SinhVien(masv, hoten, namsinh, quequan)
VALUES ('191200238','Đào Mạnh Dương','2001-09-22','Hà Nội') ,
       ('191200239','Phạm Văn Khoa','2001-12-30','Hà Nội') ,
       ('191200240','Nguyễn Văn Hiến','2001-12-11','Hà Tĩnh') ,
       ('191200241','Hồ Việt Mỹ','2001-1-12','Nghệ An') ,
       ('191200242','Trương Tuấn Cường','2001-2-28','Hải Dương') ,
       ('191200243','Nguyễn Văn Định','2001-4-30','Phú Thọ') ,
       ('191200244','Lê Bảo Ngọc','1999-7-27','Cà Mau') ,
       ('191200245','Nguyễn Thị Lê Na','1998-08-27','TPHCM') ,
       ('191200246','Hồ Anh Pháp','2001-09-29','Bắc Giang') ;

INSERT INTO DeTai(tendt, kinhphi, NoiThucTap)
VALUES ('Quản lý kho',1500000,'Công Ty PM X') ,
       ('Quản lý thư viện',3500000,'Công Ty PM Y') ,
       ('Quản lý đăng kí học',2000000,'Công Ty PM Z') ,
       ('Quản lý quán cafe',2500000,'Công Ty PM A') ,
       ('Quản lý siêu thị',3500000,'Công Ty PM C') ,
       ('QUẢN LÝ SINH HỌC',3500000,'Công Ty PM C') ;

INSERT INTO HuongDan(masv, madt, magv, ketqua)
VALUES ('191200246',6,'GV1911999','0') ,
       ('191200243',1,'GV1912000','1') ,
       ('191200241',3,'GV1912004','2') ,
       ('191200244',2,'GV1912003','2') ,
       ('191200244',2,'GV1912003','1') ,
       ('191200243',4,'GV1912002','1') ;

/*
    2.a : Lấy tất cả các sinh viên chưa có đề tài hướng dẫn
*/

SELECT
       s.masv,
       s.hoten
FROM SinhVien s
    LEFT JOIN HuongDan HD
        on s.masv = HD.masv
WHERE HD.masv IS NULL
ORDER BY masv;

/*
    2.b :  Lấy ra số sinh viên làm đề tài ‘CONG NGHE SINH HOC’
*/
SELECT
       COUNT(HD.masv) AS SumSV
FROM HuongDan HD
    JOIN DeTai DT
        on DT.madt = HD.madt
WHERE DT.tendt = 'QUẢN LÝ SINH HỌC'
GROUP BY DT.tendt;

/*
    3. Tạo view có tên là "SinhVienInfo" lấy các thông tin về học sinh bao gồm:
    mã số, họ tên và tên đề tài
    (Nếu sinh viên chưa có đề tài thì column tên đề tài sẽ in ra "Chưa có")
*/
DROP VIEW IF EXISTS  SinhVienInfo;
CREATE OR REPLACE VIEW SinhVienInfo AS(
    SELECT
           SV.masv,
           SV.hoten,
           CASE
                WHEN HD.madt IS NULL THEN 'Chưa có'
                ELSE DT.tendt
            END AS 'tendt'
    FROM SinhVien SV
        LEFT JOIN HuongDan HD
            on SV.masv = HD.masv
        LEFT JOIN DeTai DT
            on DT.madt = HD.madt
);

/*
   4. Tạo trigger cho table SinhVien khi insert sinh viên có năm sinh <= 1900
      thì hiện ra thông báo "năm sinh phải > 1900"
*/
DROP TRIGGER IF EXISTS addSinhVien;
DELIMITER $$
CREATE TRIGGER addSinhVien
    BEFORE INSERT ON SinhVien
    FOR EACH ROW
    BEGIN
        IF (YEAR(NEW.namsinh) < 1900)
            THEN
                SIGNAL SQLSTATE '12345'
                SET MESSAGE_TEXT = 'Năm sinh phải > 1900';
        end if;
    end$$
DELIMITER ;



/*
    4. Hãy cấu hình table sao cho khi xóa 1 sinh viên nào đó thì sẽ tất cả thông
    tin trong table HuongDan liên quan tới sinh viên đó sẽ bị xóa đi
    
    Thêm ON DELETE CASCADE vào khóa ngoại masv ở bảng HuongDan 
*/
/*DROP TRIGGER IF EXISTS DeletSinhVien;
DELIMITER $$
CREATE TRIGGER DeletSinhVien
    AFTER DELETE ON SinhVien
    FOR EACH ROW
    BEGIN
        DELETE FROM HuongDan HD
            WHERE HD.masv = OLD.masv;
        DELETE FROM SinhVien SV
            WHERE SV.masv = OLD.masv;
    end$$
DELIMITER ;*/


INSERT INTO SinhVien
VALUES ('191200247','Nông Văn A','1899-09-20','Bắc Giang');

DELETE FROM SinhVien
WHERE masv = '191200241';
