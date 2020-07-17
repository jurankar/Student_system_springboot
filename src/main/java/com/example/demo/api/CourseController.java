package com.example.demo.api;


import com.example.demo.model.Course;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("api/v1/course")
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> getCourses(){
        return courseService.getAllCourses();
    }

    @GetMapping(path = "{id}")
    public Course getPersonById(@NotNull @PathVariable("id") UUID id){
        return courseService.getCourseByID(id)
                .orElse(null);
    }

    @PostMapping
    public UUID createNewCourse(@NotNull @RequestBody Course course){
        return courseService.insertNewCourse(course);
    }

    @DeleteMapping(path = "{id}")
    public void deleteCourse(@NotNull @PathVariable("id") UUID id){
        courseService.deleteCourse(id);
    }

    @PutMapping(path = "{id}")
    public void updateCourse(@NotNull @PathVariable("id") UUID id, @NotNull @Valid @RequestBody Course course){
        courseService.updateCourse(id, course);
    }

    @PutMapping(path = "{name}/enroll")
    public void enrollCourse(@NotNull @PathVariable("name") String name){
        courseService.enrollClassByName(name, true);
    }

    @PutMapping(path = "{name}/cancel_enroll")
    public void cancel_enrollCourse(@NotNull @PathVariable("name") String name){
        courseService.enrollClassByName(name, true);
    }

}