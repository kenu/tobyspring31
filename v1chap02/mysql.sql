GRANT ALL PRIVILEGES ON `springbook`.* TO spring@localhost
    IDENTIFIED BY 'book' WITH GRANT OPTION;

create database springbook;

use springbook;

create table `springbook`.users (
    id varchar(10) primary key,
    name varchar(20) not null,
    password varchar(10) not null
);

GRANT ALL PRIVILEGES ON `testdb`.* TO spring@localhost
    IDENTIFIED BY 'book' WITH GRANT OPTION;

create database testdb;

use testdb;

create table `testdb`.users (
    id varchar(10) primary key,
    name varchar(20) not null,
    password varchar(10) not null
);