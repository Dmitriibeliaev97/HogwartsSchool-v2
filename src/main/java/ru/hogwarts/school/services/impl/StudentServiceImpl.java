package ru.hogwarts.school.services.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.model.StudentsByCategory;
import ru.hogwarts.school.repository.StudentRepository;
import ru.hogwarts.school.services.StudentService;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Profile("prod")
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Override
    public Student add(Student student) {
        logger.debug("Was invoked a method to create a student");
        return studentRepository.save(student);
    }

    @Override
    public Student get(Long id) {
        logger.debug("Was invoked a method to find a student by id");
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
        logger.debug("Was invoked a method to update a student");
        return studentRepository.save(savedStudent);
    }

    @Override
    public void remove(Long id) {
        logger.debug("Was invoked a method to delete a student");
        studentRepository.deleteById(id);
    }

    @Override
    public Collection<Student> getStudentByAge(int age) {
        logger.debug("Was invoked a method to find a student by age");
        return studentRepository.findByAge(age);
    }

    @Override
    public Collection<Student> getAllStudents() {
        logger.debug("Was invoked a method to find all students");
        return studentRepository.findAll();
    }

    @Override
    public Collection<Student> getStudentsBetweenAge(int min, int max) {
        logger.debug("Was invoked a method to find students between some age");
        return studentRepository.findByAgeBetween(min, max);
    }

    @Override
    public Faculty getFacultyOfStudent(Long id) {
        logger.debug("Was invoked a method to find faculty of student");
        return studentRepository.getById(id).getFaculty();
    }

    @Override
    public Integer getStudentCount() {
        logger.debug("Was invoked a method to get student count");
        return studentRepository.getStudentCount();
    }

    @Override
    public Integer getAverageAgeOfStudents() {
        logger.debug("Was invoked a method to find average age of students");
        return studentRepository.getAverageAgeOfStudents();
    }

    @Override
    public Collection<StudentsByCategory> getLastFiveStudents() {
        logger.debug("Was invoked a method to find last five students");
        return studentRepository.getLastFiveStudents();
    }

    @Override
    public Collection<String> getAllStudentsFrom(String letter) {
        logger.debug("Was invoked a method to find all students from ");
        Collection<Student> allStudents = studentRepository.findAll();
        Collection<String> studentsNames = allStudents.stream()
                .filter(s -> s.getName().startsWith(letter))
                .map(Student::getName)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        return studentsNames;
    }

    @Override
    public Integer getAverageAge() {
        logger.debug("Was invoked a method to get average age of students v2");
        Collection<Student> allStudents = studentRepository.findAll();
        Integer averageAge = (int) allStudents.stream()
                .mapToInt(Student::getAge)
                .average()
                .getAsDouble();
        return averageAge;
    }

    @Override
    public List<String> getAllStudentsStream() {
        List<Student> allStudents = new ArrayList<>(studentRepository.findAll());
        List<String> studentsNames = allStudents.stream()
                .map(Student::getName)
                .collect(Collectors.toList());

        System.out.println(studentsNames.get(0));
        System.out.println(studentsNames.get(1));

        new Thread(() -> {
            System.out.println(studentsNames.get(1));
            System.out.println(studentsNames.get(4));
        }).start();

        new Thread(() -> {
            System.out.println(studentsNames.get(2));
            System.out.println(studentsNames.get(5));
        }).start();
       return studentsNames;

    }

}
