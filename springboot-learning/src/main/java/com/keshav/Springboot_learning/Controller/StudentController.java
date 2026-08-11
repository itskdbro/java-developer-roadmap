package com.keshav.Springboot_learning.Controller;

import com.keshav.Springboot_learning.Entity.Student;
import com.keshav.Springboot_learning.Service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudent() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Student>> getStudentByAge(@RequestParam Integer age) {
        return ResponseEntity.ok(studentService.getStudentByAge(age));
    }

    @GetMapping("/search/name-age")
    public ResponseEntity<List<Student>> getStudentByNameAndAge(@RequestParam String name, @RequestParam Integer age) {
        return ResponseEntity.ok(studentService.getStudentByNameAndAge(name,age));
    }
    @GetMapping("/search/greater")
    public ResponseEntity<List<Student>> getStudentByAgeGreaterThan(@RequestParam Integer age) {
        return ResponseEntity.ok(studentService.getStudentByAgeGreaterThan(age));
    }
    @GetMapping("/search/name")
    public ResponseEntity<List<Student>> getStudentByNameContaining(@RequestParam String name) {
        return ResponseEntity.ok(studentService.getStudentByNameContaining(name));
    }
    @GetMapping("/search/younger")
    public ResponseEntity<List<Student>> getStudentByAgeYoungerThan(@RequestParam Integer age) {
        return ResponseEntity.ok(studentService.getStudentByAgeYOungerThan(age));
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student savedStudent = studentService.addStudent(student);
        return ResponseEntity.status(201).body(savedStudent);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Integer id, @RequestBody Student updatedStudent) {
        return ResponseEntity.ok(studentService.updateStudent(id, updatedStudent));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Student Removed Successfully");
    }

}
