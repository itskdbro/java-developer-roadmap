package com.keshav.Springboot_learning.DTO;

public class CourseResponseDTO {
    private Integer id;
    private String name;
    private Integer duration;

    public CourseResponseDTO(){

    }
    public CourseResponseDTO(Integer id, String name, Integer duration) {
        this.id = id;
        this.name = name;
        this.duration = duration;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getDuration() {
        return duration;
    }
}
