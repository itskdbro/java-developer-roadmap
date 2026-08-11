package com.keshav.Springboot_learning.Repository;

import com.keshav.Springboot_learning.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student, Integer> {
    List<Student> findByAge(Integer age);

    List<Student> findByNameAndAge(String name, Integer age);

    List<Student> findByAgeGreaterThan(Integer age);

    List<Student> findByNameContaining(String name);

    @Query("Select s From Student s Where s.age < :age")
    List<Student> findStudentsYoungerThan(@Param("age") Integer age);
}
