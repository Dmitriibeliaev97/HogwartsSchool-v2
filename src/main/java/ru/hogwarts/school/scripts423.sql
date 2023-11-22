SELECT student.name, student.age, faculty.name
FROM student
FULL JOIN faculty ON student.faculty = faculty.name

ALTER TABLE student
ADD avatar_id INTEGER REFERENCES avatar(id);

SELECT student.name, avatar.name, avatar.id
FROM student
INNER JOIN avatar ON student.avatar_id = avatar.id