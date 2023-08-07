Select * from student;

select * from student where age > 11 and age < 13;

select name from student;

select * from student where name like '%а%';

select * from student where age < student.id;

select * from student order by age;

select * from student, faculty where student.faculty_id = faculty.id;



