package com.keshav.Springboot_learning.DTO;

import org.springframework.stereotype.Component;

import java.util.List;

public class StudentResponseDTO {
    private Integer id;
    private String name;
    private Integer age;
    private List<CourseResponseDTO> courses;

    public StudentResponseDTO(Integer id, String name, Integer age,List<CourseResponseDTO> courses) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.courses = courses;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<CourseResponseDTO> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseResponseDTO> courses) {
        this.courses = courses;
    }
}
