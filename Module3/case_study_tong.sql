create database newspaper;

use newspaper;


create table account(
account_id int primary key auto_increment,
user_name varchar(45) not null,
password varchar(45) not null,
address varchar(45),
phone_number varchar(45),
email varchar(45) not null
);

create table catalogi(
catalogi_id int primary key,
catalogi_name varchar(45)
);

create table newspaper(
news_id int primary key,
title varchar(45),
content varchar(160),
date_submitted varchar(45),
account_id int not null,
catalogi_id int not null,
foreign key (catalogi_id)
references catalogi (catalogi_id),
foreign key (account_id)
references account (account_id)
);

drop table newspaper;

insert into account(user_name, password, address, phone_number, email) values('datcute', '123', 'hue', '0987654321', 'datcute@gmail.com');
insert into account(user_name, password, address, phone_number, email) values('khai', '123', 'quang binh', '098761221', 'khailor@gmail.com');

select * from account;
select * from newspaper;
select news_id,title,content,date_submitted from newspaper;	
select news_id,title,content,date_submitted from newspaper where newspaper.title like concat("%",title,"%");

insert into catalogi(catalogi_id, catalogi_name) values(1, 'charity');
insert into catalogi(catalogi_id, catalogi_name) values(2, 'donations');
insert into catalogi(catalogi_id, catalogi_name) values(3, 'news');

insert into newspaper(news_id, title, content, date_submitted, account_id, catalogi_id) values (1, 'a', '123wqeqweqw', '2022-10-23', 1, 1);
insert into newspaper(news_id, title, content, date_submitted, account_id, catalogi_id) values (2, 'b', 'dgfyg237432', '2022-5-8', 1, 1);
insert into newspaper(news_id, title, content, date_submitted, account_id, catalogi_id) values (3, 'fadg', 'jbdvbGYCGY74', '2022-12-09', 1, 1);
insert into newspaper(news_id, title, content, date_submitted, account_id, catalogi_id) values (4, 'dong', 'FDSVG2asa', '2022-1-17', 1, 1);