CREATE TABLE UserData
(
    id int PRIMARY KEY,
    username VARCHAR(20) NOT NULL UNIQUE KEY,
    password VARCHAR(20) NOT NULL,
    firstname VARCHAR(30) NOT NULL,
    lastname VARCHAR(30) NOT NULL,
    email VARCHAR(30) NOT NULL
);