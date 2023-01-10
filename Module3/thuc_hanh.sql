create database c1022g1_module_3;
use c1022g1_module_3;
-- Tạo bảng 
create table student (
id int,
`name` varchar(50),
score double
);
-- Đưa dữ liệu vào bảng
insert into student (id, name, score) values (1, "Quang Khải", 2.6);
-- Lấy dữ liệu ra xem
select * from student;
select name 'Tên', score 'Điểm' from student;
-- Sửa điểm
update student
set score = 5.0
where id = 1;
-- Xóa student theo id
delete from student where id = 1;
-- Thêm cột status trong table student
alter table student add `status` varchar(40);
drop database c1022g1_module_3;