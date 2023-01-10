create database demo_table;
use demo_table;
-- Tạo bảng 
create table student (
id int,
`name` varchar(50),
score double
);
-- Đưa dữ liệu vào bảng
insert into student (id, name, score, `status`) values (1, "Quang Khải", 2.6, "abccsfd");
insert into student (id, name, score, `status`) values (5, "Quang Khải", 4.8, "shgaka");
select * from student;
select name 'Tên', score 'Điểm' from student;
-- Sửa điểm
SET SQL_SAFE_UPDATES = 0;
update student
set score = 5.1
where id = 1;
set sql_safe_updates = 1;
-- Xóa student theo id
delete from student where id = 1;
-- Thêm cột status trong table student
alter table student add `status` varchar(40);
drop database demo_table;