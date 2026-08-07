package com.keshav.Springboot_learning.Controller;

import com.keshav.Springboot_learning.Entity.Student;
import org.springframework.web.bind.annotation.*;

import java.sql.Struct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    List<Student> students = new ArrayList<>();

    public StudentController() {
        Student s1 = new Student(101, "Keshav", 23);
        Student s2 = new Student(102, "Ravi", 24);
        students.add(s1);
        students.add(s2);
    }

    @GetMapping
    public List<Student> getAllStudent() {
        return students;
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Integer id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    @PostMapping("/add")
    public String addStudent(@RequestBody Student student) {
        if (student != null) {
            students.add(student);
            return "Student added Successfully";
        }
        return "Failed to add Student !!!";
    }

    @PutMapping("/update/{id}")
    public String updateStudent(@PathVariable Integer id, @RequestBody Student updatedStudent) {
        for (Student student : students) {
            if (student.getId() == id) {
                student.setName(updatedStudent.getName());
                student.setAge(updatedStudent.getAge());
                return "Student details updated Successfully";
            }
        }
        return "Student Not Found";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Integer id) {
        for (Student student : students) {
            if (student.getId() == id) {
                students.remove(student);
                return "Student removed Successfully";
            }
        }
        return "Student Not Found";

    }

}
