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
        var courses = courseService.getAllCourses();
        return courses;
    }

    @GetMapping(path = "/enrolled")
    public List<Course> getEnrolledCourses(){
        return courseService.getEnrolledCourses();
    }

    @GetMapping(path = "/{id}")
    public Course getCourseById(@NotNull @PathVariable("id") UUID id){
        return courseService.getCourseByID(id)
                .orElse(null);
    }

    @GetMapping(path = "/name/{id}")
    public Course getCourseById(@NotNull @PathVariable("name") String name){
        return courseService.getCourseByName(name)
                .orElse(null);
    }

    @PostMapping
    public UUID createNewCourse(@NotNull @RequestBody Course course){
        var course_ = courseService.insertNewCourse(course);
        return course_;
    }

    @DeleteMapping(path = "/{id}")
    public void deleteCourse(@NotNull @PathVariable("id") UUID id){
        courseService.deleteCourse(id);
    }

    @PutMapping(path = "/{id}")
    public void updateCourse(@NotNull @PathVariable("id") UUID id, @NotNull @Valid @RequestBody Course course){
        courseService.updateCourse(id, course);
    }

    @PutMapping(path = "/{name}/enroll")
    public void enrollCourse(@NotNull @PathVariable("name") String name){
        courseService.enrollClassByName(name, "true");
    }

    @PutMapping(path = "/{name}/cancel_enroll")
    public void cancel_enrollCourse(@NotNull @PathVariable("name") String name){
        courseService.enrollClassByName(name, "false");
    }

}
