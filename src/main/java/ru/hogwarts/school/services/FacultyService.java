package ru.hogwarts.school.services;

import ru.hogwarts.school.model.Faculty;

public interface FacultyService {
    Faculty add(Faculty faculty);

    Faculty get(Long id);

    Faculty update(Long id, Faculty student);

    void remove(Long id);
}
