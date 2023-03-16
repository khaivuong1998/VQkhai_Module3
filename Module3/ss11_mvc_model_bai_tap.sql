create database ss11_bai_tap;
use ss11_bai_tap;
create table books (
id int primary key auto_increment,
title varchar(50) not null,
page_size int not null,
author varchar(50),
category varchar(50)
);
select * from books;
insert into books (title, page_size, author, category) values 
("Khám phá khoa học",100,"david","Khám phá"),
("Cậu bé Rồng",90,"sydfgsd","Truyện tranh"),
("fhsgvhsvb",76,"dv","23hsgd"),
("4375wfwgyef",66,"ágd","hsd3sdf"),
("576ghsdhgs",343,"fggd","sdvds"),
("rjh347sd",180,"43hsd","5347eg");