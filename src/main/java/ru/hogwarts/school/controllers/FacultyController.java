package ru.hogwarts.school.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.services.FacultyService;

import java.util.List;

@RestController
@RequestMapping("/faculties")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping("{id}")
    public Faculty get(@PathVariable Long id) {
        return facultyService.get(id);
    }

    @PostMapping
    public Faculty add(@RequestBody Faculty faculty) {
        return facultyService.add(faculty);
    }

    @PutMapping
    public ResponseEntity<Faculty> update(@PathVariable Long id, @RequestBody Faculty faculty) {
        Faculty savedFaculty = facultyService.update(id, faculty);
        if (savedFaculty == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(savedFaculty);
        }
    }

    @DeleteMapping("{id}")
    public void remove(@PathVariable Long id) {
        facultyService.remove(id);
    }

    @GetMapping("/by-color")
    public List<Faculty> getFacultyByColor(@RequestParam String color) {
        return facultyService.getFacultyByColor(color);
    }

    @GetMapping
    public List<Faculty> getAllFaculties() {
        return facultyService.getAllFaculties();
    }

    @GetMapping
    public List<Faculty> getFacultyByName(@RequestParam String name) {
        return facultyService.getFacultyByName(name);
    }

    @GetMapping
    public Faculty getFacultyOfStudent (@RequestParam String name) {
        return facultyService.getFacultyOfStudent(name);
    }
}
