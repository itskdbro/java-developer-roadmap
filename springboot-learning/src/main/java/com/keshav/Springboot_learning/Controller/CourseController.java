package com.keshav.Springboot_learning.Controller;

import com.keshav.Springboot_learning.Entity.Course;
import com.keshav.Springboot_learning.Service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/student/{studentId}")
    public ResponseEntity<Course> addCourse(@PathVariable Integer studentId, @RequestBody Course course){
        return ResponseEntity.status(201).body(courseService.addCourse(studentId, course));
    }
}
