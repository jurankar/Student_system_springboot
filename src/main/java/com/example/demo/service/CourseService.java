package com.example.demo.service;


import com.example.demo.dao.CourseDao;
import com.example.demo.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CourseService {

    private CourseDao courseDao;

    @Autowired
    public CourseService(@Qualifier("noPostgresDao") CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    public List<Course> getAllCourses() {
        return courseDao.getCourses();
    }

    public UUID insertNewCourse(Course course) {
        return courseDao.addCourse(course);
    }

    public Optional<Course> getCourseByID(UUID courseId) {
        return courseDao.getCourse(courseId);
    }

    public Optional<Course> getCourseByName(String courseName) {
        return courseDao.getCourseByName(courseName);
    }

    public void deleteCourse(UUID coursId) {
        courseDao.deleteCourse(coursId);
    }

    public void updateCourse(UUID courseID, Course course) {
        courseDao.updateCourse(courseID, course);
    }

    public void enrollClassByName(String courseName, boolean enroll) {
        Course course = getCourseByName(courseName).get();
        UUID courseId = course.getCourseId();

        Course updated_course = new Course(course.getCourseId(), course.getCourseName(), course.getDescription(), enroll);
        updateCourse(courseId, updated_course);
    }

}


