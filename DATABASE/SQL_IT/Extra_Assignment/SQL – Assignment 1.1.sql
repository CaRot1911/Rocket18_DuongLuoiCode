DROP DATABASE IF EXISTS freshermanager;
CREATE DATABASE freshermanager;

USE freshermanager;

# Tạo table với các ràng buộc và kiểu dữ liệu

CREATE TABLE Trainee (
    TraineeID 			INT AUTO_INCREMENT 					NOT NULL,
    Full_Name 			CHAR(30) 							NOT NULL,
    Birth_Date 			DATE 								NOT NULL,
    Gender 				ENUM('male', 'female', 'unknown') 	NOT NULL,
    ET_IQ 				TINYINT 							NOT NULL,
    ET_Gmath 			TINYINT 							NOT NULL,
    ET_English 			TINYINT 							NOT NULL,
    Training_Class 		CHAR(20) 							NOT NULL,
    Evaluation_Notes 	TEXT 								NULL,
    PRIMARY KEY (TraineeID)
);

# thêm trường VTI_Account với điều kiện not null & unique

ALTER TABLE Trainee
ADD COLUMN VTI_Account CHAR(30) NOT NULL UNIQUE;

SELECT 
    *
FROM
    Trainee;
