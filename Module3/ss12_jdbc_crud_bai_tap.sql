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
delete from user where id = ?;
set sql_safe_updates = 0;
update user set name = ?, email= ?, country =? where id = ?;
select * from user where id = ?;
delimiter //
create procedure find_by_id_user(in id int)
begin select * from user 
where user.id = id;
end //
delimiter ;
call find_by_id_user(?);
set sql_safe_updates = 1;