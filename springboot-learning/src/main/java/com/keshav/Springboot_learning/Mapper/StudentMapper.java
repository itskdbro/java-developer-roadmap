package com.keshav.Springboot_learning.Mapper;

import com.keshav.Springboot_learning.DTO.CourseResponseDTO;
import com.keshav.Springboot_learning.DTO.StudentRequestDTO;
import com.keshav.Springboot_learning.DTO.StudentResponseDTO;
import com.keshav.Springboot_learning.Entity.Course;
import com.keshav.Springboot_learning.Entity.Student;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentMapper {
    private final CourseMapper courseMapper;
    public StudentMapper(CourseMapper courseMapper){
        this.courseMapper = courseMapper;
    }

    public Student toEntity(StudentRequestDTO studentDTO) {
        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setAge(studentDTO.getAge());
        return student;
    }

    public StudentResponseDTO toResponseDTO(Student student) {
        List<CourseResponseDTO> courses = student.getCourses().stream().map(courseMapper::toCourseResponseDTO).toList();
        return new StudentResponseDTO(student.getId(), student.getName(), student.getAge(),courses);
    }
}
