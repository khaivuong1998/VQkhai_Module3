use ss04_thuc_hanh_quan_ly_sinh_vien;
select * from Subject
where credit = (select max(credit) from Subject);
select * from Subject;

select Subject.sub_name, mark.mark 
from Subject 
inner join Mark on Subject.sub_id = mark.sub_id
where mark.mark = (select max(mark) from mark);
select student.student_name as 'Học sinh', 
avg(mark.mark) as 'Điểm trung bình' 
from student 
inner join mark on student.student_id = mark.student_id 
group by student.student_id 
order by     'Điểm trung bình' desc;