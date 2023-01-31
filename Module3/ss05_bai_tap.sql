create database ss05_bai_tap;
use ss05_bai_tap;
create table products (
id int primary key,
product_code varchar(50),
product_name varchar(50),
product_price varchar(50),
product_amount varchar(50),
product_description varchar(50),
product_status varchar(50)
);
select * from products;
insert into products(
  product_code, product_name, product_price, 
  product_amount, product_description, 
  product_status
) 
values 
  ('01', 'máy điều hòa', '10020395', '12', 'first hand', 'vip'), 
  ('02', 'nồi cơm điện', '234987', '5', 'made in vn', 'bt'), 
  ('03', 'xe máy', '34215000', '7', 'vn high quality', 'vip pro');
-- Bước 3
create index index_product_code on products (product_code);
create index index_product_name_price on products (product_name, product_price);
drop 
  index index_product_code on products;
drop 
  index index_product_name_price on products;
explain 
select 
  * 
from 
  products 
where 
  product_code = '01';
explain 
select 
  * 
from 
  products 
where 
  product_name = 'máy điều hòa';
explain 
select 
  * 
from 
  products 
where 
  product_price = '10020395';
-- Bước 4
create view view_products(
  product_code_view, product_name_view, 
  product_price_view, product_status_view
) as 
select 
  product_code, 
  product_name, 
  product_price, 
  product_status 
from 
  products;
select 
  * 
from 
  view_products;
set 
  sql_safe_updates = 0;
update 
  view_products 
set 
  product_status_view = 'first hand' 
where 
  product_code_view = '01';
set 
  sql_safe_updates = 1;
drop 
  view view_products;
-- Bước 5
delimiter // create procedure list_all_information() begin 
select 
  * 
from 
  products;
end // delimiter;
call list_all_information;
delimiter // create procedure add_new_product(
  product_code varchar(45), 
  product_name varchar(45), 
  product_price varchar(45), 
  product_amount varchar(45), 
  product_description varchar(45), 
  product_status varchar(45)
) begin insert into products(
  product_code, product_name, product_price, 
  product_amount, product_description, 
  product_status
) 
values 
  (
    product_code, product_name, product_price, 
    product_amount, product_description, 
    product_status
  );
end // delimiter;
call add_new_product (
  '04', 'ô tô', '2393428700', 
  '05', 'bàn điện', 'almost vip'
);
delimiter // create procedure edit_by_id(
  id int, 
  product_code varchar(45), 
  product_name varchar(45), 
  product_price varchar(45), 
  product_amount varchar(45), 
  product_description varchar(45), 
  product_status varchar(45)
) begin 
update 
  products 
set 
  products.product_code = product_code, 
  products.product_name = product_name, 
  products.product_price = product_price, 
  products.product_amount = product_amount, 
  products.product_description = product_description, 
  products.product_status = product_status 
where 
  products.id = id;
end // delimiter;
call edit_by_id (4, '', '', '', '', '', '');
delimiter // create procedure delete_by_id (id int) begin 
DELETE FROM products 
WHERE
    products.id = id;
end // delimiter;
call delete_by_id(4);
