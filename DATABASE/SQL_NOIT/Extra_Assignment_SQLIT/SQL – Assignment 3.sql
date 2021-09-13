USE adventureworks;

# Exercise 1: Subquery

/* Question 1: Viết 1 query lấy thông tin "Name" từ bảng Production.Product có name
của ProductSubcategory là 'Saddles'.
*/
SELECT 
    *
FROM
    product;
SELECT 
    p1.Name
FROM
    product p1
WHERE
    p1.ProductSubcategoryID IN (SELECT 
            ps.ProductSubcategoryID
        FROM
            ProductSubcategory ps
        WHERE
            ps.Name = 'Saddles');

/*
    Thay đổi câu Query 1 để lấy được kết quả sau.
*/
SELECT 
    p1.Name
FROM
    product p1
WHERE
    p1.ProductSubcategoryID IN (SELECT 
            ps.ProductSubcategoryID
        FROM
            ProductSubcategory ps
        WHERE
            ps.Name LIKE 'Bo%')
ORDER BY p1.Name DESC;

/*
 Question 3:
Viết câu query trả về tất cả các sản phẩm có giá rẻ nhất (lowest ListPrice) và Touring
Bike (nghĩa là ProductSubcategoryID = 3)
*/
SELECT 
    *
FROM
    productsubcategory;
SELECT 
    *
FROM
    product;

SELECT 
    p1.Name
FROM
    product p1
WHERE
    p1.ListPrice = (SELECT 
            MIN(ListPrice)
        FROM
            product
        WHERE
            ProductSubcategoryID = 3);

# Exercise 2: JOIN nhiều bảng

/*
Question 1: Viết query lấy danh sách tên country và province được lưu trong
AdventureWorks2008sample database.
*/

SELECT 
    *
FROM
    countryregion;
SELECT 
    *
FROM
    stateprovince;

SELECT 
    c.Name, s.Name
FROM
    countryregion c
        JOIN
    stateprovince s ON c.CountryRegionCode = s.CountryRegionCode;


/*
Question 2: Tiếp tục với câu query trước và thêm điều kiện là chỉ lấy country
Germany và Canada
*/
SELECT 
    c.Name, s.Name
FROM
    countryregion c
        JOIN
    stateprovince s ON c.CountryRegionCode = s.CountryRegionCode
WHERE
    c.Name = 'Germany' OR c.Name = 'Canada'
ORDER BY c.Name;

/*
Question 3:
SalesOrderID, OrderDate and SalesPersonID. Từ bảng SalesPerson, chúng ta lấy cột
BusinessEntityID (là định danh của người sales), Bonus and the SalesYTD (là đã sale
được bao nhiêu người trong năm nay)
*/

SELECT 
    *
FROM
    SalesOrderHeader;
SELECT 
    *
FROM
    SalesPerson;

SELECT 
    s.SalesOrderID,
    s.OrderDate,
    s.SalesPersonID,
    s1.Bonus AS 'BusinessEntityID',
    s1.SalesYTD AS 'Bonus'
FROM
    SalesOrderHeader s
        INNER JOIN
    SalesPerson s1 ON s.SalesPersonID = s1.SalesPersonID;

/*
    Question 4:
Sử dụng câu query, thêm cột JobTitle and xóa cột SalesPersonID và
BusinessEntityID
*/
SELECT 
    *
FROM
    employee emp
WHERE
    emp.Title LIKE 'Sales%';
SELECT 
    s.SalesOrderID,
    s.OrderDate,
    e.Title,
    s1.Bonus AS 'BusinessEntityID',
    s1.SalesYTD AS 'Bonus'
FROM
    SalesOrderHeader s
        INNER JOIN
    SalesPerson s1 ON s.SalesPersonID = s1.SalesPersonID
        INNER JOIN
    employee e ON s1.SalesPersonID = e.EmployeeID;