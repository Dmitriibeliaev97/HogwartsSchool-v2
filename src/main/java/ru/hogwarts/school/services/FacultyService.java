package ru.hogwarts.school.services;

import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.Collection;

public interface FacultyService {
    Faculty add(Faculty faculty);

    Faculty get(Long id);

    Faculty update(Long id, Faculty student);

    void remove(Long id);
    Collection<Faculty> getFacultyByColor(String color);

    Collection<Faculty> getFacultyByNameOrColor(String name, String color);

    Collection<Faculty> getAllFaculties();

    Collection<Student> getStudentsOfFaculties(Long id);
}
