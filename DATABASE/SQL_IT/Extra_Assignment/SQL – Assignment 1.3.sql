DROP DATABASE IF EXISTS Data_Types2;
CREATE DATABASE Data_Types2;

USE Data_Types2;

CREATE TABLE Infor (
    ID 				INT AUTO_INCREMENT 		NOT NULL PRIMARY KEY,
    Name 			CHAR(30) 				NOT NULL,
    BirthDate 		DATE 					NOT NULL,
    Gender 			ENUM('0', '1', 'NULL') 	NOT NULL,
    IsDeletedFlag	ENUM('0', '1') 			NOT NULL
);