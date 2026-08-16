package com.keshav.Springboot_learning.Service;

import com.keshav.Springboot_learning.DTO.StudentRequestDTO;
import com.keshav.Springboot_learning.DTO.StudentResponseDTO;
import com.keshav.Springboot_learning.Entity.Course;
import com.keshav.Springboot_learning.Entity.Student;
import com.keshav.Springboot_learning.Exceptions.StudentNotFoundException;
import com.keshav.Springboot_learning.Mapper.StudentMapper;
import com.keshav.Springboot_learning.Repository.StudentRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepo studentRepo;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepo studentRepo, StudentMapper studentMapper) {
        this.studentRepo = studentRepo;
        this.studentMapper = studentMapper;
    }

    public List<StudentResponseDTO> getAllStudents() {
        return studentRepo.findAll().stream().map(studentMapper::toResponseDTO).toList();
    }


    public StudentResponseDTO getStudentById(Integer id) {
        Student student = studentRepo.findById(id).orElseThrow(() ->
                new StudentNotFoundException("Student with ID " + id + " not found"));
        return studentMapper.toResponseDTO(student);
    }

    public List<StudentResponseDTO> getStudentByAge(Integer age) {
        return studentRepo.findByAge(age).stream().map(studentMapper::toResponseDTO).toList();
    }

    public StudentResponseDTO addStudent(StudentRequestDTO studentDTO) {
        Student student = studentMapper.toEntity(studentDTO);
        Student savedStudent = studentRepo.save(student);
        return studentMapper.toResponseDTO(savedStudent);
    }

    public StudentResponseDTO updateStudent(Integer id, StudentRequestDTO updatedStudent) {
        Student existingStudent = studentRepo.findById(id).orElseThrow(() -> new StudentNotFoundException("Student with ID " + id + " not found"));
        existingStudent.setName(updatedStudent.getName());
        existingStudent.setAge(updatedStudent.getAge());
        Student savedStudent = studentRepo.save(existingStudent);
        return studentMapper.toResponseDTO(savedStudent);
    }

    public void deleteStudent(Integer id) {
        Student existingStudent = studentRepo.findById(id).orElseThrow(() -> new StudentNotFoundException("Student with ID " + id + " not found"));
        studentRepo.delete(existingStudent);
    }

    public List<StudentResponseDTO> getStudentByNameAndAge(String name, Integer age) {
        return studentRepo.findByNameAndAge(name, age).stream().map(studentMapper::toResponseDTO).toList();
    }

    public List<StudentResponseDTO> getStudentByAgeGreaterThan(Integer age) {
        return studentRepo.findByAgeGreaterThan(age).stream().map(studentMapper::toResponseDTO).toList();
    }

    public List<StudentResponseDTO> getStudentByNameContaining(String name) {
        return studentRepo.findByNameContaining(name).stream().map(studentMapper::toResponseDTO).toList();
    }

    public List<StudentResponseDTO> getStudentByAgeYoungerThan(Integer age) {
        return studentRepo.findStudentsYoungerThan(age).stream().map(studentMapper::toResponseDTO).toList();
    }

    public List<StudentResponseDTO> getStudents(String name, Integer age) {
        return studentRepo.searchStudents(name, age).stream().map(studentMapper::toResponseDTO).toList();
    }

    public List<StudentResponseDTO> getStudentBySortedAge() {
//        return studentRepo.findAll(Sort.by("age"));   // Ascending order
        return studentRepo.findAll(Sort.by(Sort.Direction.DESC, "age")).stream().map(studentMapper::toResponseDTO).toList();
    }

    public List<StudentResponseDTO> getSortedStudents(String field, String direction) {
        Sort sort;
        if (direction.equalsIgnoreCase("ASC")) {
            sort = Sort.by(Sort.Direction.ASC, field);
        } else {
            sort = Sort.by(Sort.Direction.DESC, field);
        }
        return studentRepo.findAll(sort).stream().map(studentMapper::toResponseDTO).toList();
    }

    public Page<StudentResponseDTO> getStudents(Pageable pageable) {
        return studentRepo.findAll(pageable).map(studentMapper::toResponseDTO);
    }

    public List<Course> getCourseByStudent(Integer studentID) {
        Student student = studentRepo.findById(studentID).orElseThrow(() -> new StudentNotFoundException("Student with ID " + studentID + " not found"));
        return student.getCourses();
    }
}
