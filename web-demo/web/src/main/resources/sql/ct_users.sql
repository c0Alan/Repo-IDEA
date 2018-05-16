create table users(
    id serial primary key,
    name varchar(40),
    password varchar(40),
    email varchar(60),
    birthday date
);