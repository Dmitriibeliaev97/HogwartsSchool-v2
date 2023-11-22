package ru.hogwarts.school.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.FacultyRepository;
import ru.hogwarts.school.services.FacultyService;

import java.util.Collection;
import java.util.Comparator;

@Service
@Profile("prod")
public class FacultyServiceImpl implements FacultyService {
    private final FacultyRepository facultyRepository;

    public FacultyServiceImpl(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }
    private static final Logger logger = LoggerFactory.getLogger(FacultyServiceImpl.class);

    @Override
    public Faculty add(Faculty faculty) {
        logger.debug("Was invoked a method to create a faculty");
        return facultyRepository.save(faculty);
    } // CREATE

    @Override
    public Faculty get(Long id) {
        logger.debug("Was invoked a method to find a faculty by id");
        return facultyRepository.findById(id).orElse(null);
    } // READ

    @Override
    public Faculty update(Long id, Faculty faculty) { // UPDATE
        Faculty savedFaculty = get(id);
        if (savedFaculty == null) {
            return null;
        }
        savedFaculty.setName(faculty.getName());
        savedFaculty.setColor(faculty.getColor());
        logger.debug("Was invoked a method to update a faculty");
        return facultyRepository.save(savedFaculty);
    }

    @Override
    public void remove(Long id) {
        logger.debug("Was invoked a method to delete a faculty");
        facultyRepository.deleteById(id);
    } // DELETE

    @Override
    public Collection<Faculty> getFacultyByColor(String color) {
        logger.debug("Was invoked a method to find a faculty by color");
        return facultyRepository.findByColorIgnoreCase(color);
    }

    @Override
    public Collection<Faculty> getFacultyByNameOrColor(String name, String color) {
        logger.debug("Was invoked a method to find a faculty by name or color");
        return facultyRepository.findByNameIgnoreCaseOrColorIgnoreCase(name, color);
    }

    @Override
    public Collection<Faculty> getAllFaculties() {
        logger.debug("Was invoked a method to find all faculties");
        return facultyRepository.findAll();
    }

    @Override
    public Collection<Student> getStudentsOfFaculties(Long id) {
        logger.debug("Was invoked a method to find all students of faculty");
        return facultyRepository.getById(id).getStudents();
    }

    public String longestNameOfFaculty() {
        Collection<Faculty> allFaculties = facultyRepository.findAll();
        String longestName = allFaculties.stream()
                .map(Faculty::getName)
                .max(Comparator.comparing(String::length))
                .orElse(null);
        return longestName;
    }
}