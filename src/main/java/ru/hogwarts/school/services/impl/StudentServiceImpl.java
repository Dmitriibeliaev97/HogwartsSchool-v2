package ru.hogwarts.school.services.impl;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.services.StudentService;

import java.util.HashMap;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {
    private final Map<Long, Student> students = new HashMap<>();
    private static long counter = 0;

    @Override
    public Student add(Student student) {
        student.setId(++counter);
        students.put(student.getId(), student);
        return students.get(student.getId());
    }

    @Override
    public Student get(Long id) {
        return students.get(id);
    }

    @Override
    public Student update(Long id, Student student) {
        Student savedStudent = students.get(id);
        if (savedStudent == null) {
            return null;
        }
        savedStudent.setAge(student.getAge());
        savedStudent.setName(student.getName());
        return savedStudent;
    }

    @Override
    public void remove(Long id) {
        students.remove(id);
    }
}
