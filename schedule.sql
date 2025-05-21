drop table if exists lv1schedule;

drop table if exists lv3schedule;
drop table if exists lv3user;

create table if not exists lv1schedule (
    id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    username VARCHAR(10),
    password VARCHAR(30),
    title VARCHAR(20),
    content VARCHAR(200),
    createdAt DATETIME,
    modifiedAt DATETIME
);

create table if not exists lv3user (
    id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name VARCHAR(10),
    password VARCHAR(30) NOT NULL,
    email VARCHAR(30),
    createdAt DATETIME,
    modifiedAt DATETIME
);

create table if not exists lv3schedule (
    id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    user_id int NOT NULL,
    title VARCHAR(20),
    content VARCHAR(200),
    createdAt DATETIME,
    modifiedAt DATETIME,
    FOREIGN KEY(user_id) references lv3user (id)
);