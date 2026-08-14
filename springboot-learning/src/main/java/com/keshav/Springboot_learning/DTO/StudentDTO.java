package com.keshav.Springboot_learning.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public class StudentDTO {
    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Age is required")
    @Min(value = 18,message = "Age must be atleast 18")
    private Integer age;

    public StudentDTO(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public StudentDTO() {

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
}
