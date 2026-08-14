package com.keshav.Springboot_learning.Controller;

import com.keshav.Springboot_learning.DTO.StudentDTO;
import com.keshav.Springboot_learning.Entity.Student;
import com.keshav.Springboot_learning.Service.StudentService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @GetMapping("/age/sorted")
    public ResponseEntity<List<Student>> getStudentBySortedAge() {
        return ResponseEntity.ok(studentService.getStudentBySortedAge());
    }

    @GetMapping("/sorted")
    public ResponseEntity<List<Student>> getSortedStudents(@RequestParam String field, @RequestParam String direction) {
        return ResponseEntity.ok(studentService.getSortedStudents(field, direction));
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
        return ResponseEntity.ok(studentService.getStudentByNameAndAge(name, age));
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

    @GetMapping("/searchStudents")
    public ResponseEntity<List<Student>> getStudents(@RequestParam String name, @RequestParam Integer age) {
        return ResponseEntity.ok(studentService.getStudents(name, age));
    }

    @GetMapping("/page")
    public ResponseEntity<Page<Student>> getStudents(Pageable pageable){
        return ResponseEntity.ok(studentService.getStudents(pageable));
    }

    @PostMapping
    public ResponseEntity<StudentDTO> addStudent(@RequestBody StudentDTO studentDTO) {
        return ResponseEntity.status(201).body(studentService.addStudent(studentDTO));
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
