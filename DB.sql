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

SHOW TABLES;

SELECT *
FROM article;

DESC article;


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

DELETE FROM article
WHERE id = 2;

SELECT *
FROM article;


