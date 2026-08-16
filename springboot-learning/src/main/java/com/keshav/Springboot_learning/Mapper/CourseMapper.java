package com.keshav.Springboot_learning.Mapper;

import com.keshav.Springboot_learning.DTO.CourseResponseDTO;
import com.keshav.Springboot_learning.Entity.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {
    public CourseResponseDTO toCourseResponseDTO(Course course) {
        return new CourseResponseDTO(course.getId(), course.getName(), course.getDuration());
    }
}
