package com.keshav.Springboot_learning.Repository;

import com.keshav.Springboot_learning.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student, Integer> {
    List<Student> findByAge(Integer age);
}
