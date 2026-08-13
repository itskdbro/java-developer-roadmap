package com.keshav.Springboot_learning.Repository;

import com.keshav.Springboot_learning.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student, Integer> {
    List<Student> findByAge(Integer age);

    List<Student> findByNameAndAge(String name, Integer age);

    @Query(value = "Select * From Student where age > :age", nativeQuery = true)
    List<Student> findByAgeGreaterThan(@Param("age") Integer age);

    List<Student> findByNameContaining(String name);

    @Query("Select s From Student s Where s.age < :age")
    List<Student> findStudentsYoungerThan(@Param("age") Integer age);

    @Query("""
            SELECT s
            FROM Student s
            WHERE s.name LIKE CONCAT('%', :name, '%')
            AND s.age > :age
            """)
    List<Student> searchStudents(
            @Param("name") String name,
            @Param("age") Integer age);
}
