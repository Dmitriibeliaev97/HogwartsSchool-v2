package ru.hogwarts.school.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.services.StudentService;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("{id}")
    public Student get(@PathVariable Long id) {
        return studentService.get(id);
    }

    @PostMapping
    public Student add(@RequestBody Student student) {
        return studentService.add(student);
    }

    @PutMapping
    public ResponseEntity<Student> update(@RequestBody Student student) {
        Student savedStudent = studentService.update(student);
        if (savedStudent == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(savedStudent);
        }
    }

    @DeleteMapping("{id}")
    public void remove(@PathVariable Long id) {
        studentService.remove(id);
    }

    @GetMapping("/by-age")
    public List<Student> getStudentsByAge(@RequestParam int age) {
        return studentService.getStudentByAge(age);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping
    public List<Student> getStudentBetweenAge(@RequestParam int min, int max) {
        return studentService.getStudentsBetweenAge(min, max);
    }
    @GetMapping
    public List<Student> getStudentsOfFaculty(@RequestParam String facultyName) {
        return studentService.getAllStudentsOfFaculty(facultyName);
    }
}
