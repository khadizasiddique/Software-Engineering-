create database  library;

show databases;

use library;

show tables;

create table admin(username varchar(50),password varchar(50));

insert into admin values('admin','admin');

select * from admin;

create table librarian(Lid int primary key not null auto_increment,name varchar(50),password varchar(50),email varchar(50),contact varchar(50),address varchar(50),city varchar(50))

select * from librarian;

create table addbook(id int primary key auto_increment not null,BookNo varchar(50),bookname varchar(50),author varchar(50),publisher varchar(50),quantity int,issuebook int default 0,date varchar(50));

select * from addbook;

create table issuebook(BookId varchar(50),bookno varchar(50),bookname varchar(50),studentid varchar(50),studentname varchar(50),studentcontact varchar(50),date varchar(50));

select * from issuebook;

