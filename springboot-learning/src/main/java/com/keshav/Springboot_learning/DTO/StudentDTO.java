package com.keshav.Springboot_learning.DTO;

import jakarta.validation.constraints.*;

public class StudentDTO {
    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 30, message = "Name must be between 2 and 30 characters")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Name can contain only letters")
    private String name;

    @NotNull(message = "Age is required")
    @Min(value = 18, message = "Age must be atleast 18")
    @Max(value = 60, message = "Age must not exceed 60")
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
