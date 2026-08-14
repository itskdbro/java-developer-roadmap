package com.keshav.Springboot_learning.Controller;

import com.keshav.Springboot_learning.DTO.StudentRequestDTO;
import com.keshav.Springboot_learning.DTO.StudentResponseDTO;
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

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<StudentResponseDTO>> getAllStudent() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/age/sorted")
    public ResponseEntity<List<StudentResponseDTO>> getStudentBySortedAge() {
        return ResponseEntity.ok(studentService.getStudentBySortedAge());
    }

    @GetMapping("/sorted")
    public ResponseEntity<List<StudentResponseDTO>> getSortedStudents(@RequestParam String field, @RequestParam String direction) {
        return ResponseEntity.ok(studentService.getSortedStudents(field, direction));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> getStudentById(@PathVariable Integer id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<StudentResponseDTO>> getStudentByAge(@RequestParam Integer age) {
        return ResponseEntity.ok(studentService.getStudentByAge(age));
    }

    @GetMapping("/search/name-age")
    public ResponseEntity<List<StudentResponseDTO>> getStudentByNameAndAge(@RequestParam String name, @RequestParam Integer age) {
        return ResponseEntity.ok(studentService.getStudentByNameAndAge(name, age));
    }

    @GetMapping("/search/greater")
    public ResponseEntity<List<StudentResponseDTO>> getStudentByAgeGreaterThan(@RequestParam Integer age) {
        return ResponseEntity.ok(studentService.getStudentByAgeGreaterThan(age));
    }

    @GetMapping("/search/name")
    public ResponseEntity<List<StudentResponseDTO>> getStudentByNameContaining(@RequestParam String name) {
        return ResponseEntity.ok(studentService.getStudentByNameContaining(name));
    }

    @GetMapping("/search/younger")
    public ResponseEntity<List<StudentResponseDTO>> getStudentByAgeYoungerThan(@RequestParam Integer age) {
        return ResponseEntity.ok(studentService.getStudentByAgeYoungerThan(age));
    }

    @GetMapping("/searchStudents")
    public ResponseEntity<List<StudentResponseDTO>> getStudents(@RequestParam String name, @RequestParam Integer age) {
        return ResponseEntity.ok(studentService.getStudents(name, age));
    }

    @GetMapping("/page")
    public ResponseEntity<Page<StudentResponseDTO>> getStudents(Pageable pageable) {
        return ResponseEntity.ok(studentService.getStudents(pageable));
    }

    @PostMapping
    public ResponseEntity<StudentResponseDTO> addStudent(@Valid @RequestBody StudentRequestDTO requestDTO) {
        return ResponseEntity.status(201).body(studentService.addStudent(requestDTO));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<StudentResponseDTO> updateStudent(@PathVariable Integer id, @Valid @RequestBody StudentRequestDTO updatedStudent) {
        return ResponseEntity.ok(studentService.updateStudent(id, updatedStudent));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Student Removed Successfully");
    }

}
