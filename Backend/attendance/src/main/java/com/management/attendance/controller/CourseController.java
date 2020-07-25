package com.management.attendance.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    @GetMapping("/courses")
    public String getListOfCourse(){
        return "We dont have courses yet";
    }
}
