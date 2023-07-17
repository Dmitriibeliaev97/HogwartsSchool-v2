package ru.hogwarts.school.services.impl;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;
import ru.hogwarts.school.services.FacultyService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacultyServiceImpl implements FacultyService {
    private final FacultyRepository facultyRepository;
    public FacultyServiceImpl(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @Override
    public Faculty add(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    @Override
    public Faculty get(Long id) {
        return facultyRepository.findById(id).get();
    }

    @Override
    public Faculty update(Long id, Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    @Override
    public void remove(Long id) {
        facultyRepository.deleteById(id);
    }

    @Override
    public List<Faculty> getFacultyByColor(String color) {
        return facultyRepository.findByColor(color);
    }

    @Override
    public List<Faculty> getAllFaculties() {
        return facultyRepository.findAll();
    }
}