create database ss10_demo;
use ss10_demo;
create table student (
id int primary key auto_increment,
`name` varchar(45) not null,
score double not null
);
select * from student;
insert into student (`name`, score) values ("Nguyễn Văn D", 4.7);
delimiter //
create procedure student_search(in `name` varchar(40))
begin
select * from student where student.`name` like concat("%",`name`,"%");
end //
delimiter ;
drop procedure student_search;
call student_search(?);
-- select * from student where name like concat("%",?,"%");
set sql_safe_updates = 0;
delimiter //
create procedure update_student(in `name` varchar(40), in score double, in id int)
begin
update student 
set student.`name` = `name`, student.score = score 
where 	student.id = id;
end //
delimiter ;
drop procedure update_student;
delete from student where id = ?;
call update_student(?,?,?);
set sql_safe_updates = 1;
