create database ss11_bai_tap;
use ss11_bai_tap;
create table books (
id int primary key auto_increment,
title varchar(50) not null,
page_size int not null,
author varchar(50) not null,
category_id int,
foreign key(category_id) references category(category_id)
);
create table category (
category_id int primary key auto_increment,
`name` varchar(50) not null
);
drop table books;
select * from books;
select * from category;
set sql_safe_updates = 0;
insert into books (title, page_size, author, category_id) values (?, ?, ?, ?);
update books set title = ?, page_size = ?, author = ?, category_id = ? where id = ?;
delimiter //
create procedure find_by_id_books(in id int)
begin select * from books
where books.id = id;
end //
delimiter ;
delimiter //
create procedure books_search(in title varchar(50))
begin 
select * from books where books.title like concat("%",title,"%");
end //
delimiter ;
call books_search(?);
call find_by_id_books(?);
insert into books (title, page_size, author, category_id) values 
("Khám phá khoa học",100,"david", 2),
("Cậu bé Rồng",90,"sydfgsd", 3),
("fhsgvhsvb",76,"dv", 1),
("4375wfwgyef",66,"ágd", 1),
("576ghsdhgs",343,"fggd", 2),
("rjh347sd",180,"43hsd", 4);
insert into category (category_id, `name`) values
(1, "tiểu thuyết"),
(2, "Truyện tranh"),
(3, "trinh thám"),
(4, "khoa học");
set sql_safe_updates = 1;