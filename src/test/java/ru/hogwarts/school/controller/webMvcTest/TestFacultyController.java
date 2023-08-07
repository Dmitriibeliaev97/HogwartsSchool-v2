package ru.hogwarts.school.controller.webMvcTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ru.hogwarts.school.controllers.FacultyController;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.services.AvatarService;
import ru.hogwarts.school.services.FacultyService;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FacultyController.class)
public class TestFacultyController {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private FacultyService facultyService;
    @MockBean
    private AvatarService avatarService;
    @InjectMocks
    private FacultyController facultyController;
    @Autowired
    private ObjectMapper objectMapper;
    @Test
    public void addFacultyTest() throws Exception {
        Long id = 1L;
        String name = "Barbie";
        String color = "Pink";

        Faculty faculty = new Faculty();
        faculty.setId(id);
        faculty.setName(name);
        faculty.setColor(color);

        when(facultyService.add(any(Faculty.class))).thenReturn(faculty);

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/faculties")
                        .content(objectMapper.writeValueAsBytes(faculty))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.name").value(name))
                .andExpect(jsonPath("$.color").value(color));
    }

    @Test
    public void getFacultyByColorTest() throws Exception {
        List<Faculty> faculties = new ArrayList<>();
        Long id = 1L;
        String name = "Barbie";
        String color = "Pink";

        Faculty faculty = new Faculty();
        faculty.setId(id);
        faculty.setName(name);
        faculty.setColor(color);

        faculties.add(faculty);

        when(facultyService.getFacultyByColor(color)).thenReturn(faculties);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/faculties/by-color/" + color)
                        .content(objectMapper.writeValueAsBytes(faculty))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(faculties.size())));
    }

    @Test
    public void deleteFacultyTest() throws Exception {
        Long id = 1L;
        String name = "Barbie";
        String color = "Pink";

        Faculty faculty = new Faculty();
        faculty.setId(id);
        faculty.setName(name);
        faculty.setColor(color);

        when(facultyService.add(any(Faculty.class))).thenReturn(faculty);

        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/faculties/" + id)
                        .content(objectMapper.writeValueAsBytes(faculty))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getAllFacultiesTest() throws Exception {
        List<Faculty> faculties = new ArrayList<>();
        Long id = 1L;
        String name = "Barbie";
        String color = "Pink";

        Faculty faculty = new Faculty();
        faculty.setId(id);
        faculty.setName(name);
        faculty.setColor(color);

        faculties.add(faculty);

        when(facultyService.getAllFaculties()).thenReturn(faculties);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/faculties")
                        .content(objectMapper.writeValueAsBytes(faculty))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(faculties.size())));
    }

    @Test
    public void getFacultyByNameOrColorTest() throws Exception {
        List<Faculty> faculties = new ArrayList<>();
        Long id = 1L;
        String name = "Barbie";
        String color = "Pink";

        Faculty faculty = new Faculty();
        faculty.setId(id);
        faculty.setName(name);
        faculty.setColor(color);

        faculties.add(faculty);

        when(facultyService.getFacultyByNameOrColor(name, color)).thenReturn(faculties);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/faculties/findFaculty")
                        .content(objectMapper.writeValueAsBytes(faculty))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void updateFacultyTest() throws Exception {
        Long id = 1L;
        String name = "Barbie";
        String color = "Pink";

        Faculty faculty = new Faculty();
        faculty.setId(id);
        faculty.setName(name);
        faculty.setColor(color);

        when(facultyService.update(id, faculty)).thenReturn(faculty);

        mockMvc.perform(MockMvcRequestBuilders
                        .put("/faculties/update/{id}", id)
                        .content(objectMapper.writeValueAsBytes(faculty))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.name").value(name))
                .andExpect(jsonPath("$.color").value(color));
    }
    @Test
    public void getStudentsByIdOfFacultyCopy() throws Exception {
        List<Student> students = new ArrayList<>();
        Long facultyID = 1L;
        String facultyName = "Barbie";
        String color = "Pink";

        Long id = 1L;
        String name = "Bob";
        int age = 12;

        Faculty faculty = new Faculty();
        faculty.setId(facultyID);
        faculty.setName(facultyName);
        faculty.setColor(color);

        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setAge(age);
        student.setFaculty(faculty);

        students.add(student);

        when(facultyService.getStudentsOfFaculties(any(Long.class))).thenReturn(students);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/faculties/studentsByID/{id}", id )
                        .content(objectMapper.writeValueAsBytes(student))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(faculty))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
