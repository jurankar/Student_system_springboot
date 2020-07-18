package com.example.demo.model;

import java.util.UUID;

public class Course {

    private UUID courseId;
    private String courseName;
    private String description;
    private String enrolled;

    //constructor
    public Course(UUID courseId, String courseName, String description, String enrolled) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.description = description;
        this.enrolled = enrolled;
    }

    //setters
    public void setCourseId(UUID courseId) {
        this.courseId = courseId;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEnrolled(String enrolled) {
        this.enrolled = enrolled;
    }

    //getters
    public UUID getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getDescription() {
        return description;
    }

    public String isEnrolled() {
        return enrolled;
    }


}
