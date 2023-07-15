package ru.hogwarts.school.services.impl;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.services.FacultyService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FacultyServiceImpl implements FacultyService {
    private final Map<Long, Faculty> faculties = new HashMap<>();
    private static long counter = 0;

    @Override
    public Faculty add(Faculty faculty) {
        faculty.setId(++counter);
        return this.faculties.put(faculty.getId(), faculty);
    }

    @Override
    public Faculty get(Long id) {
        return faculties.get(id);
    }

    @Override
    public Faculty update(Long id, Faculty faculty) {
        Faculty savedFaculty = faculties.get(id);
        if (savedFaculty == null) {
            return null;
        }
        savedFaculty.setName(faculty.getName());
        savedFaculty.setColor(faculty.getColor());
        return savedFaculty;
    }

    @Override
    public void remove(Long id) {
        faculties.remove(id);
    }

    @Override
    public List<Faculty> getFacultyByColor(String color) {
        return faculties.values()
                .stream()
                .filter(it -> it.getColor().equals(color))
                .collect(Collectors.toList());
    }
}