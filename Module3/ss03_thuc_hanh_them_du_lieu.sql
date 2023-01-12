create database ss03_thuc_hanh_them_du_lieu;
use ss03_thuc_hanh_them_du_lieu;
CREATE TABLE class (
    class_id INT PRIMARY KEY AUTO_INCREMENT,
    class_name VARCHAR(60) NOT NULL,
    start_date DATETIME NOT NULL,
    status BIT
);
CREATE TABLE student (
    student_id INT PRIMARY KEY AUTO_INCREMENT,
    student_name VARCHAR(30) NOT NULL,
    address VARCHAR(50),
    phone VARCHAR(20),
    status BIT,
    class_id INT NOT NULL,
    FOREIGN KEY (class_id)
        REFERENCES class (class_id)
);
create table `subject`(
sub_id int primary key auto_increment,
sub_name varchar(30) not null,
credit tinyint default 1 check (credit >= 1) not null,
status bit default 1
);
CREATE TABLE mark (
    mark_id INT PRIMARY KEY AUTO_INCREMENT,
    sub_id INT NOT NULL,
    student_id INT NOT NULL,
    mark FLOAT DEFAULT 0 CHECK (mark BETWEEN 0 AND 100),
    exam_times TINYINT DEFAULT 1,
    UNIQUE (sub_id , student_id),
    FOREIGN KEY (sub_id)
        REFERENCES `subject` (sub_id),
    FOREIGN KEY (student_id)
        REFERENCES student (student_id)
);
insert into class values (1, 'A1', '2008-12-20', 1);
insert into class values (2, 'A2', '2008-12-22', 1);
insert into class values (3, 'B3', current_date, 0);
insert into student (student_name, address, phone, status, class_id) values ('Hung', 'Ha Noi', '0912113113', 1, 1);
insert into student (student_name, address, status, class_id) values ('Hoa', 'Hai phong', 1, 1);
insert into student (student_name, address, phone, status, class_id) values ('Manh', 'HCM', '0123123123', 0, 2);
insert into `subject` values (1, 'CF', 5, 1), (2, 'C', 6, 1), (3, 'HDJ', 5, 1), (4, 'RDBMS', 10, 1);
insert into mark (sub_id, student_id, mark, exam_times) values (1, 1, 8, 1), (1, 2, 10, 2), (2, 1, 12, 1);
select * from class;
select * from student;
select * from `subject`;
select * from mark;
-- drop database ss03_thuc_hanh_them_du_lieu;