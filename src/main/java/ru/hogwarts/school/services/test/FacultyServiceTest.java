package ru.hogwarts.school.services.test;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.services.FacultyService;

import java.util.Collection;
@Service
@Profile("test")
public class FacultyServiceTest implements FacultyService {
    @Override
    public Faculty add(Faculty faculty) {
        return null;
    }

    @Override
    public Faculty get(Long id) {
        return null;
    }

    @Override
    public Faculty update(Long id, Faculty faculty) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public Collection<Faculty> getFacultyByColor(String color) {
        return null;
    }

    @Override
    public Collection<Faculty> getFacultyByNameOrColor(String name, String color) {
        return null;
    }

    @Override
    public Collection<Faculty> getAllFaculties() {
        return null;
    }

    @Override
    public Collection<Student> getStudentsOfFaculties(Long id) {
        return null;
    }

    @Override
    public String longestNameOfFaculty() {
        return null;
    }
}
