package com.keshav.Springboot_learning.Mapper;

import com.keshav.Springboot_learning.DTO.StudentRequestDTO;
import com.keshav.Springboot_learning.DTO.StudentResponseDTO;
import com.keshav.Springboot_learning.Entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public Student toEntity(StudentRequestDTO studentDTO) {
        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setAge(studentDTO.getAge());
        return student;
    }

    public StudentResponseDTO toResponseDTO(Student student) {
        return new StudentResponseDTO(student.getId(), student.getName(), student.getAge());
    }
}
