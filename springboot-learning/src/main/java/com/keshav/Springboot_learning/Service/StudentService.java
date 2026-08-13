package com.keshav.Springboot_learning.Service;

import com.keshav.Springboot_learning.Entity.Student;
import com.keshav.Springboot_learning.Exceptions.StudentNotFoundException;
import com.keshav.Springboot_learning.Repository.StudentRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public Student getStudentById(Integer id) {
        return studentRepo.findById(id).orElseThrow(() -> new StudentNotFoundException("Student with ID " + id + " not found"));

    }

    public List<Student> getStudentByAge(Integer age) {
        return studentRepo.findByAge(age);
    }

    public Student addStudent(Student student) {
        return studentRepo.save(student);
    }

    public Student updateStudent(Integer id, Student updatedStudent) {
        Student existingStudent = studentRepo.findById(id).orElseThrow(() -> new StudentNotFoundException("Student with ID " + id + " not found"));
        existingStudent.setName(updatedStudent.getName());
        existingStudent.setAge(updatedStudent.getAge());

        return studentRepo.save(existingStudent);
    }

    public void deleteStudent(Integer id) {
        Student existingStudent = studentRepo.findById(id).orElseThrow(() -> new StudentNotFoundException("Student with ID " + id + " not found"));
        studentRepo.delete(existingStudent);
    }

    public List<Student> getStudentByNameAndAge(String name, Integer age) {
        return studentRepo.findByNameAndAge(name, age);
    }

    public List<Student> getStudentByAgeGreaterThan(Integer age) {
        return studentRepo.findByAgeGreaterThan(age);
    }

    public List<Student> getStudentByNameContaining(String name) {
        return studentRepo.findByNameContaining(name);
    }

    public List<Student> getStudentByAgeYOungerThan(Integer age) {
        return studentRepo.findStudentsYoungerThan(age);
    }

    public List<Student> getStudents(String name, Integer age) {
        return studentRepo.searchStudents(name, age);
    }

    public List<Student> getStudentBySortedAge() {
//        return studentRepo.findAll(Sort.by("age"));   // Ascending order
        return studentRepo.findAll(Sort.by(Sort.Direction.DESC, "Age"));
    }

    public List<Student> getSortedStudents(String field, String direction) {
        Sort sort;
        if (direction.equalsIgnoreCase("ASC")) {
            sort = Sort.by(Sort.Direction.ASC, field);
        } else {
            sort = Sort.by(Sort.Direction.DESC, field);
        }
        return studentRepo.findAll(sort);
    }

    public Page<Student> getStudents(Pageable pageable) {
        return studentRepo.findAll(pageable);
    }
}
