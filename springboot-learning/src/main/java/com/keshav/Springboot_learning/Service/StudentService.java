package com.keshav.Springboot_learning.Service;

import com.keshav.Springboot_learning.Entity.Student;
import com.keshav.Springboot_learning.Exceptions.StudentNotFoundException;
import com.keshav.Springboot_learning.Repository.StudentRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    List<Student> students = new ArrayList<>();


    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public ResponseEntity<Student> getStudentById(Integer id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return ResponseEntity.ok(student);
            }
        }
        throw new StudentNotFoundException("Student with ID " + id + " not found");
    }

    public ResponseEntity<List<Student>> getStudentByAge(Integer age) {
        List<Student> studentList = new ArrayList<>();
        for (Student student : students) {
            if (student.getAge() == age) {
                studentList.add(student);
            }
        }
        return ResponseEntity.ok(studentList);
    }

    public Student addStudent(Student student) {
        return studentRepo.save(student);
    }

    public Student updateStudent(Integer id, Student updatedStudent) {
        return studentRepo.findById(id).orElseThrow(() -> new StudentNotFoundException("Student with ID " + id + " not found"));

    }

    public ResponseEntity<String> deleteStudent(Integer id) {
        boolean removed = students.removeIf(student -> student.getId() == id);
        if (removed) {
            return ResponseEntity.ok("Student Removed Successfully");
        }
        throw new StudentNotFoundException("Student with ID " + id + " not found");
    }
}
