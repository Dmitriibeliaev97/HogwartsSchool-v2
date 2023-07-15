package ru.hogwarts.school.services;

import ru.hogwarts.school.model.Faculty;

import java.util.List;

public interface FacultyService {
    Faculty add(Faculty faculty);

    Faculty get(Long id);

    Faculty update(Long id, Faculty student);

    void remove(Long id);
    List<Faculty> getFacultyByColor (String color);
}
