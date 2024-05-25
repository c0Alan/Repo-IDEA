
DROP DATABASE IF EXISTS db_javaweb;
CREATE DATABASE db_javaweb DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_general_ci;
use db_javaweb;

DROP TABLE IF EXISTS account;
/*创建账户表*/
create table account(
    id int primary key auto_increment,
    name varchar(40),
    money float
);

/*插入测试数据*/
insert into account(name,money) values('A',1000);
insert into account(name,money) values('B',1000);
insert into account(name,money) values('C',1000);

DROP TABLE IF EXISTS users;
create table users(
      id int primary key auto_increment,
      name varchar(40),
      password varchar(40),
      email varchar(60),
      birthday date
);
INSERT INTO users (id, name, password, email, birthday) VALUES ('1', '李白', '123', '123', NULL);


DROP TABLE IF EXISTS testclob;
create table testclob
(
    id int primary key auto_increment,
    resume MEDIUMTEXT
);

DROP TABLE IF EXISTS testblob;
create table testblob
(
   id int primary key auto_increment,
   image longblob
);

DROP TABLE IF EXISTS testbatch;
create table testbatch
(
    id int primary key,
    name varchar(20)
);