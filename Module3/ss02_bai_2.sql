create database ss02_bai_2;
use ss02_bai_2;
create table customer(
c_id int primary key,
c_name varchar(45) not null,
c_age int not null
);
create table `order`(
o_id int primary key,
o_date date not null,
o_total_price double not null,
c_id int not null,
constraint fk_o_c_id foreign key(c_id) references customer(c_id)
);
create table product(
p_id int primary key,
p_name varchar(45) not null,
p_price double not null
);
create table order_detail(
o_id int not null,
p_id int not null,
primary key (o_id, p_id),
constraint fk_o_o_d_id foreign key(o_id) references `order`(o_id),
constraint fk_p_o_d_id foreign key(p_id) references product(p_id),
o_d_qty double not null
);
-- drop database ss02_bai_2;