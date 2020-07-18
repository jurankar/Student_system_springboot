package com.example.demo.dao;

import com.example.demo.model.Course;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CourseDao {

    UUID addCourse(UUID id, Course course);

    default UUID addCourse(Course course){
        UUID id = UUID.randomUUID();
        return addCourse(id, course);
    }

    List<Course> getCourses();

    List<Course> getEnrolledCourses();

    Optional<Course> getCourse(UUID id);

    Optional<Course> getCourseByName(String courseName);

    int deleteCourse(UUID id);

    int updateCourse(UUID id, Course course);



}
