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