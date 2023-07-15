package ru.hogwarts.school.services;

import ru.hogwarts.school.model.Student;

public interface StudentService {
    Student add(Student student);

    Student get(Long id);

    Student update(Long id, Student student);

    void remove(Long id);
}
