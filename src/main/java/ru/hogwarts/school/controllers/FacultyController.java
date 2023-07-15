package ru.hogwarts.school.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.services.FacultyService;

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
        Faculty savedFacultyt = facultyService.update(id, faculty);
        if (savedFacultyt == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(savedFacultyt);
        }
    }

    @DeleteMapping("{id}")
    public void remove(@PathVariable Long id) {
        facultyService.remove(id);
    }
}
