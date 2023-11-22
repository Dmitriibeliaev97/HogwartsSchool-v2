package ru.hogwarts.school.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hogwarts.school.model.StudentsByCategory;
import ru.hogwarts.school.services.StudentService;

import java.util.Collection;

@RestController
@RequestMapping("/students-by-category")
public class StudentsByCategoryController {

    private final StudentService studentService;

    public StudentsByCategoryController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/student-count")
    public Integer getStudentCount() {
        return studentService.getStudentCount();
    }

    @GetMapping("/average-age-of-students")
    public Integer getAverageAgeOfStudents() {
        return studentService.getAverageAgeOfStudents();
    }

    @GetMapping("/last-five-sudents")
    public Collection<StudentsByCategory> getLastFiveStudents() {
        return studentService.getLastFiveStudents();
    }
}
