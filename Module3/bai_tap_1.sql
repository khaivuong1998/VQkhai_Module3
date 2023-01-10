create database bai_tap_1;
use bai_tap_1;
create table class (
id int,
`name` varchar(40)
);
create table teacher (
id int,
`name` varchar(40),
age int,
country varchar(100)
);
select * from class;
select * from teacher;