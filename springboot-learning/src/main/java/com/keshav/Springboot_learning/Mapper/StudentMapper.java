package com.keshav.Springboot_learning.Mapper;

import com.keshav.Springboot_learning.DTO.StudentDTO;
import com.keshav.Springboot_learning.Entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public Student toEntity(StudentDTO studentDTO) {
        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setAge(studentDTO.getAge());
        return student;
    }

    public StudentDTO toDTO(Student student) {
        return new StudentDTO(student.getName(), student.getAge());
    }
}
