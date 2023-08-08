package ru.hogwarts.school.services.impl;


import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.model.StudentsByCategory;
import ru.hogwarts.school.repository.StudentRepository;
import ru.hogwarts.school.services.StudentService;

import java.util.Collection;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public Student add(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student get(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student update(Long id, Student student) {
        Student savedStudent = get(id);
        if (savedStudent == null) {
            return null;
        }
        savedStudent.setName(student.getName());
        savedStudent.setAge(student.getAge());
        return studentRepository.save(savedStudent);
    }

    @Override
    public void remove(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Collection<Student> getStudentByAge(int age) {
        return studentRepository.findByAge(age);
    }

    @Override
    public Collection<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Collection<Student> getStudentsBetweenAge(int min, int max) {
        return studentRepository.findByAgeBetween(min, max);
    }
    @Override
    public Faculty getFacultyOfStudent(Long id) {
        return studentRepository.getById(id).getFaculty();
    }

    @Override
    public Integer getStudentCount() {
        return studentRepository.getStudentCount();
    }

    @Override
    public Integer getAverageAgeOfStudents() {
        return studentRepository.getAverageAgeOfStudents();
    }

    @Override
    public Collection<StudentsByCategory> getLastFiveStudents() {
        return studentRepository.getLastFiveStudents();
    }


}
