DROP DATABASE IF EXISTS Company;
CREATE DATABASE Company;

USE Company;

DROP TABLE IF EXISTS CUSTOMER,CAR,CAR_ORDER;

CREATE TABLE CUSTOMER(
    CustomerID 		SMALLINT 	NOT NULL AUTO_INCREMENT ,
    Name 			CHAR(30) 	NOT NULL ,
    Phone 			CHAR(10) 	NOT NULL ,
    Email 			CHAR(30) 	NOT NULL ,
    Address 		TEXT 		NOT NULL ,
    Note			TEXT ,
    PRIMARY KEY (CustomerID)
);

CREATE TABLE CAR(
    CarID 		TINYINT 						NOT NULL AUTO_INCREMENT,
    Maker 		ENUM('HONDA','TOYOTA','NISSAN') NOT NULL ,
    Model 		CHAR(20) 						NOT NULL ,
    Year 		YEAR 							NOT NULL ,
    Color 		CHAR(12) 						NOT NULL ,
    Note 		TEXT 							NOT NULL ,
    PRIMARY KEY (CarID)
);

CREATE TABLE CAR_ORDER(
    OrderID 		INT 					NOT NULL AUTO_INCREMENT  ,
    CustomerID 		SMALLINT 				NOT NULL ,
    CarID 			TINYINT 				NOT NULL ,
    Amount 			TINYINT 				NOT NULL DEFAULT (1),
    SalePrice 		DECIMAL(10,2) 			NOT NULL ,
    OrderDate 		DATE 					NOT NULL ,
    DeliveryDate 	DATE 					NOT NULL ,
    DeliveryAddress TEXT 					NOT NULL ,
    Status 			ENUM('0','1','2') 		NOT NULL DEFAULT ('0'),
    Note 			TEXT,
    PRIMARY KEY (OrderID),
    FOREIGN KEY (CustomerID) REFERENCES CUSTOMER(CustomerID),
    FOREIGN KEY (CarID) REFERENCES CAR(CarID)
);

INSERT CUSTOMER(Name, Phone, Email, Address)
VALUES('Bezalel Simmel','091187651','simmel@gmail.com','Tokyo'),
       ('Parto Bamford','091187981','bamford@gmail.com','Ha Noi'),
       ('Chirstian Koblick','0913677651','koblick@gmail.com','USA'),
       ('maliniak@gmail.com','091675651','maliniak@gmail.com','Scotland'),
       ('Anneke Preusig','091181997','preusig@gmail.com','Northern Ireland'),
       ('Tzvetan Zielinski','091182200','tzvetanzielinski@gmail.com','Tokyo'),
       ('Saniya Kalloufi','091181000','saniyakalloufi@gmail.com','Northern Ireland'),
       ('Sumant Peac','091181111','sumantpeac@gmail.com','Wales'),
       ('Duangkaew Piveteau','091188888','duangkaewpiveteau@gmail.com','Tokyo'),
       ('Mary Sluis','091199999','marysluis@gmail.com','Wales');

INSERT CAR(MAKER, MODEL, YEAR, COLOR, NOTE)
VALUES ('HONDA','HD1998','1998','Red','Sport'),
       ('HONDA','HD2000','2000','Black','Family'),
       ('HONDA','HD2010','2010','Gray','Picnic'),
       ('TOYOTA','TYT19971','1997','Silver','SUV'),
       ('TOYOTA','TYT20001','2000','White','Coupe'),
       ('TOYOTA','TYT19961','1996','Orange','Pickup'),
       ('NISSAN','NSS91','1991','Green','Limousine'),
       ('NISSAN','NSS89','1989','Blue','Crossove'),
       ('NISSAN','NSS00','2000','Bronze','Hatchback');

INSERT CAR_ORDER(customerid, carid, amount, saleprice, orderdate, deliverydate, deliveryaddress, status)
VALUES (1,1,1,20000,'2000-12-29','2001-1-15','Tokyo','0'),
       (2,5,1,50000,'2010-10-29','2010-11-15','Ha Noi','0'),
       (5,9,1,100000,'2011-7-30','2011-9-19','Northern Ireland','0'),
       (9,8,1,150000,'2020-3-28','2020-9-30','Tokyo','0'),
       (3,6,1,120000,'2000-12-29','2001-1-15','USA','2'),
       (4,5,1,50000,'2012-12-12','2013-3-15','Tokyo','2');

# (0: ???? ?????t h??ng, 1: ???? giao, 2: ???? h???y)
/*
Vi???t l???nh l???y ra th??ng tin c???a kh??ch h??ng: t??n, s??? l?????ng oto kh??ch h??ng ????
mua v?? s???p s???p t??ng d???n theo s??? l?????ng oto ???? mua.
*/
SELECT 
    c.Name, COUNT(ca.Amount) AS Amount
FROM
    CUSTOMER c
        LEFT JOIN
    CAR_ORDER ca ON c.CustomerID = ca.CustomerID
GROUP BY c.Name
ORDER BY Amount DESC;

/*
Vi???t h??m (kh??ng c?? parameter) tr??? v??? t??n h??ng s???n xu???t ???? b??n ???????c nhi???u
oto nh???t trong n??m nay.
 */
DROP FUNCTION IF EXISTS max_Car;
DELIMITER $$
CREATE FUNCTION max_Car() RETURNS CHAR(20)
DETERMINISTIC
BEGIN
    DECLARE NXS CHAR (30);
WITH table_nxs AS
    (SELECT COUNT(co.Amount) FROM CAR c LEFT JOIN CAR_ORDER co ON c.CarID = co.CarID
    WHERE YEAR(NOW()) = YEAR(co.OrderDate) AND co.Status = 1
    GROUP BY c.Maker
    ORDER BY COUNT(co.Amount) DESC
    LIMIT 1)
SELECT c.Maker INTO NXS FROM CAR c LEFT JOIN CAR_ORDER co ON c.CarID = co.CarID
GROUP BY c.Maker
HAVING COUNT(co.Amount) = (SELECT * FROM table_nxs);
    RETURN NXS;
end$$
DELIMITER ;

/*
Vi???t 1 th??? t???c (kh??ng c?? parameter) ????? x??a c??c ????n h??ng ???? b??? h???y c???a
nh???ng n??m tr?????c. In ra s??? l?????ng b???n ghi ???? b??? x??a.
*/
DROP PROCEDURE IF EXISTS Delet_Order;
DELIMITER $$
CREATE PROCEDURE Delet_Order()
BEGIN
    DECLARE count INT DEFAULT 0;
SELECT 
    COUNT(c.OrderID)
INTO count FROM
    CAR_ORDER c
WHERE
    c.Status = '2'
        AND (YEAR(NOW()) > YEAR(c.OrderDate));
    DELETE FROM CAR_ORDER c
        WHERE c.Status = '2' AND (YEAR(NOW()) > YEAR(c.OrderDate));
SELECT count;
end$$
DELIMITER ;

/*
Vi???t 1 th??? t???c (c?? CustomerID parameter) ????? in ra th??ng tin c???a c??c ????n
h??ng ???? ?????t h??ng bao g???m: t??n c???a kh??ch h??ng, m?? ????n h??ng, s??? l?????ng oto
v?? t??n h??ng s???n xu???t.
*/
DROP PROCEDURE IF EXISTS InforCus;
DELIMITER $$
CREATE PROCEDURE InforCus(IN p_cusID INT)
BEGIN
 SELECT 
    c.Name, co.OrderID, co.Amount, C2.Maker
FROM
    CUSTOMER c
        LEFT JOIN
    CAR_ORDER co ON c.CustomerID = co.CustomerID
        JOIN
    CAR C2 ON C2.CarID = co.CarID
WHERE
    p_cusID = c.CustomerID;
end$$
DELIMITER ;

CALL InforCus(1);

/*
Vi???t trigger ????? tr??nh tr?????ng h???p ng?????i d???ng nh???p th??ng tin kh??ng h???p l???
v??o database (DeliveryDate < OrderDate + 15).
*/
DROP TRIGGER IF EXISTS TryCatch;
DELIMITER $$
CREATE TRIGGER TryCatch
    BEFORE INSERT ON CAR_ORDER
    FOR EACH ROW
    BEGIN
        IF(DATE(NEW.DeliveryDate) < (DATE(NEW.OrderDate)+15))
            THEN
                SIGNAL SQLSTATE '12345'
                SET MESSAGE_TEXT  = 'Delivery date must be after order date!!';
        end if;
    end$$
DELIMITER ;