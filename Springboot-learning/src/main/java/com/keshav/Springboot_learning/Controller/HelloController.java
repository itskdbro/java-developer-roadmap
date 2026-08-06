package com.keshav.Springboot_learning.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello keshav Dhawan";
    }
}
