CREATE DATABASE finalexam2;

USE finalexam2;

CREATE TABLE User(
    id          INT         NOT NULL AUTO_INCREMENT ,
    FullName    VARCHAR(50) NOT NULL ,
    Email       CHAR(50)    NOT NULL ,
    Password    CHAR(50)    NOT NULL ,
    PRIMARY KEY (id)
);
CREATE TABLE Manager(
    id          INT     NOT NULL ,
    ExpInYear   TINYINT NOT NULL ,
    PRIMARY KEY (id) ,
    FOREIGN KEY (id) REFERENCES User(id)
);
CREATE TABLE Project(
    projectID   TINYINT NOT NULL AUTO_INCREMENT,
    teamSize    TINYINT NOT NULL ,
    idManager   INT NOT NULL ,
    PRIMARY KEY (projectID) ,
    FOREIGN KEY (idManager) REFERENCES Manager(id)
);
CREATE TABLE Employee(
    id          INT         NOT NULL ,
    projectID   TINYINT     NOT NULL ,
    ProSkill     CHAR(10)    NOT NULL ,
    PRIMARY KEY (id) ,
    FOREIGN KEY (id) REFERENCES User(id),
    FOREIGN KEY (projectID) REFERENCES project(projectID)
);


INSERT User(FullName, Email, Password)
VALUES ('Nguyen Van Lung',  'nguyen.vanlung@vti.com',   '123456A'),
       ('Nguyen Van Dung',  'nguyen.vandung@vti.com',   '123456A'),
       ('Nguyen Van D',     'nguyen.vand@vti.com',      '123456AS'),
       ('Nguyen Van E',     'nguyen.vane@vti.com',      '123456'),
       ('Nguyen Van Huy',   'nguyen.vanhuy@vti.com',    '123456'),
       ('Admin',            'admin@vti.com',            '123456A'),
       ('Nguyen Van F',     'nguyen.vanf@vti.com',      '123456'),
       ('Nguyen Van G',     'nguyen.vang@vti.com',      '123456'),
       ('Nguyen Van H',     'nguyen.vanh@vti.com',      '123456'),
       ('Nguyen Van I',     'nguyen.vani@vti.com',      '123456'),
       ('Nguyen Van J',     'nguyen.vanj@vti.com',      '123456');

INSERT Manager(id,ExpInYear)
VALUES (1,3),
       (3,2),
       (4,4);

INSERT Project(teamSize, idManager)
VALUES (4,1),
       (3,3),
       (2,3);

INSERT Employee
VALUES  (2,1,'SQL'),
        (5,1,'JAVA'),
        (6,1,'FONT-END'),
        (7,1,'JS'),
        (8,2,'DEV'),
        (9,2,'TEST'),
        (10,2,'JS');


