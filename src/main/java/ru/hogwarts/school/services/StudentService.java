package ru.hogwarts.school.services;

import org.hibernate.sql.ast.tree.expression.Collation;
import ru.hogwarts.school.model.Student;

import java.util.List;

public interface StudentService {
    Student add(Student student);

    Student get(Long id);

    Student update(Student student);

    void remove(Long id);

    List<Student> getStudentByAge(int age);

    List<Student> getAllStudents();
    List<Student> getStudentsBetweenAge(int min, int max);
    List<Student> getAllStudentsOfFaculty(String facultyName);
}
