create database ss03_bai_tap_quan_ly_ban_hang;
use ss03_bai_tap_quan_ly_ban_hang;
create table customer(
c_id int primary key,
c_name varchar(25) not null,
c_age tinyint not null
);
create table `order`(
o_id int primary key,
o_date datetime not null,
o_total_price int,
c_id int not null,
constraint fk_o_c_id foreign key(c_id) references customer(c_id)
);
create table product(
p_id int primary key,
p_name varchar(25) not null,
p_price int not null
);
create table order_detail(
o_id int not null,
p_id int not null,
primary key (o_id, p_id),
constraint fk_o_o_d_id foreign key(o_id) references `order`(o_id),
constraint fk_p_o_d_id foreign key(p_id) references product(p_id),
o_d_qty int not null
);
insert into customer values (1, 'Minh Quan', 10), (2, 'Ngoc Oanh', 20), (3, 'Hong Ha', 50);
insert into `order` values (1, '2006/3/21', null, 1), (2, '2006/3/23', null, 2), (3, '2006/3/16', null, 1);
insert into product values (1, 'May Giat', 3);
insert into product values (2, 'Tu Lanh', 5);
insert into product values (3, 'Dieu Hoa', 7);
insert into product values (4, 'Quat', 1);
insert into product values (5, 'Bep Dien', 2);
insert into order_detail values (1, 1, 3);
insert into order_detail values (1, 3, 7);
insert into order_detail values (1, 4, 2);
insert into order_detail values (2, 1, 1);
insert into order_detail values (3, 1, 8);
insert into order_detail values (2, 5, 4);
insert into order_detail values (2, 3, 3);
select * from product;
select * from `order`;
select * from order_detail;
select * from customer;
-- drop database ss03_bai_tap_quan_ly_ban_hang;
