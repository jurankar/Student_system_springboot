package com.example.demo.model;

import java.util.UUID;

public class Course {

    private UUID courseId;
    private String courseName;
    private String description;
    private boolean enrolled;

    //constructor
    public Course(UUID courseId, String courseName, String description, boolean enrolled) {
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

    public void setEnrolled(boolean enrolled) {
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

    public boolean isEnrolled() {
        return enrolled;
    }


}
