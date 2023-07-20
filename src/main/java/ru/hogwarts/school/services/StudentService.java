package ru.hogwarts.school.services;

import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.Collection;

public interface StudentService {
    Student add(Student student);

    Student get(Long id);

    Student update(Student student);

    void remove(Long id);

    Collection<Student> getStudentByAge(int age);

    Collection<Student> getAllStudents();
    Collection<Student> getStudentsBetweenAge(int min, int max);
    Collection<Faculty> getFacultyOfStudent(Long id);
}
