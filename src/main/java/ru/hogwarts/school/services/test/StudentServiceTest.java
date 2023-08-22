package ru.hogwarts.school.services.test;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.model.StudentsByCategory;
import ru.hogwarts.school.services.StudentService;

import java.util.Collection;
@Service
@Profile("test")
public class StudentServiceTest implements StudentService {
    @Override
    public Student add(Student student) {
        return null;
    }

    @Override
    public Student get(Long id) {
        return null;
    }

    @Override
    public Student update(Long id, Student student) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public Collection<Student> getStudentByAge(int age) {
        return null;
    }

    @Override
    public Collection<Student> getAllStudents() {
        return null;
    }

    @Override
    public Collection<Student> getStudentsBetweenAge(int min, int max) {
        return null;
    }

    @Override
    public Faculty getFacultyOfStudent(Long id) {
        return null;
    }

    @Override
    public Integer getStudentCount() {
        return null;
    }

    @Override
    public Integer getAverageAgeOfStudents() {
        return null;
    }

    @Override
    public Collection<StudentsByCategory> getLastFiveStudents() {
        return null;
    }
}
