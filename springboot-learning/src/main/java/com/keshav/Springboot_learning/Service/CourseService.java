package com.keshav.Springboot_learning.Service;

import com.keshav.Springboot_learning.Entity.Course;
import com.keshav.Springboot_learning.Entity.Student;
import com.keshav.Springboot_learning.Exceptions.StudentNotFoundException;
import com.keshav.Springboot_learning.Repository.CourseRepo;
import com.keshav.Springboot_learning.Repository.StudentRepo;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    private final CourseRepo courseRepo;
    private final StudentRepo studentRepo;

    public CourseService(CourseRepo courseRepo, StudentRepo studentRepo) {
        this.courseRepo = courseRepo;
        this.studentRepo = studentRepo;
    }

    public Course addCourse(Integer studentId, Course course) {
        Student student = studentRepo.findById(studentId).orElseThrow(() -> new StudentNotFoundException("Student with ID " + studentId + " not found"));
        course.setStudent(student);
        return courseRepo.save(course);
    }
}
