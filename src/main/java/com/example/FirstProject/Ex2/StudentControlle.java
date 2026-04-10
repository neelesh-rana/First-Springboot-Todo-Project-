package com.example.FirstProject.Ex2;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
    @RequestMapping("/students")
public class StudentControlle {
    List<Student> students = new ArrayList<>();

    // GET all students
    @GetMapping
    public List<Student> getStudents() {
        return students;
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {

        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }

        return null;
    }





    // POST add student
    @PostMapping("/{id}")
    public String addStudent(@RequestBody Student student) {
        students.add(student);
        return "Student added";
    }

    // DELETE student by id
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        students.removeIf(s -> s.getId() == id);
        return "Student deleted";
    }
}
