create database ss12_jdbc_bai_tap;
use ss12_jdbc_bai_tap;
create table user (
id int primary key auto_increment,
`name` varchar(45) not null,
email varchar(45) not null,
country varchar(45)
);
select * from user;
insert into user (`name`,email,country) values ("Minh","minh@codegym.vn","Viet Nam");
insert into user (`name`,email,country) values ("Kante","kante@che.uk","Kenia");