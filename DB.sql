DROP DATABASE IF EXISTS `JDBC_AM`;
CREATE DATABASE `JDBC_AM`;
USE `JDBC_AM`;

CREATE TABLE article(
    id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    regDate DATETIME NOT NULL,
    updateDate DATETIME NOT NULL,
    title CHAR(100) NOT NULL,
    `body` TEXT NOT NULL
);

CREATE TABLE `member`(
    id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    regDate DATETIME NOT NULL,
    updateDate DATETIME NOT NULL,
    loginId CHAR(100) NOT NULL,
    loginPw CHAR(100) NOT NULL,
    `name` TEXT NOT NULL
);
SHOW TABLES;

SELECT *
FROM article;

DESC article;
DESC `member`;

INSERT INTO article
SET regDate = NOW(),
updateDate = NOW(),
title = CONCAT('제목', RAND()),
`body` = CONCAT('내용', RAND());

#update article
#set id = 1;

#select *
#from article
#where id = 2;

#update article
#set regDate = now(),
#title = 'title2',
#`body` = 'modified'
#WHERE id = 2;

#DELETE FROM article
#WHERE id = 2;

SELECT *
FROM article;

SELECT *
FROM `member`;

INSERT INTO `member`
SET regDate = NOW(),
updateDate = NOW(),
#loginId = 'test',
loginPw = 'test',
`name` = 'testname';



