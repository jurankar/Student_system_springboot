package com.example.demo.dao;

import com.example.demo.model.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository("noPostgresDao")
public class CourseDataAO implements CourseDao {

    private final static List<Course> fakeDatabase = new ArrayList<>();

    @Override
    public UUID addCourse(UUID id, Course course) {
        fakeDatabase.add(new Course(id, course.getCourseName(), course.getDescription(), course.isEnrolled()));
        return id;
    }

    @Override
    public List<Course> getCourses() {
        return fakeDatabase;
    }

    @Override
    public Optional<Course> getCourse(UUID id) {
        return fakeDatabase.
                stream()
                .filter(course -> course.getCourseId().equals(id))
                .findFirst();
    }

    @Override
    public Optional<Course> getCourseByName(String courseName) {
        return fakeDatabase.
                stream()
                .filter(course -> course.getCourseName().equals(courseName))
                .findFirst();
    }


    @Override
    public int deleteCourse(UUID id) {
        Optional<Course> courseOptional = getCourse(id);
        if(!courseOptional.isPresent()){
            return 0;   // --> coursa ni blo in ga nismo mogl zbrisat
        }
        fakeDatabase.remove(courseOptional.get());
        return 1;   // --> uspešno smo zbrisali course
    }

    @Override
    public int updateCourse(UUID id, Course courseChanged) {
        return getCourse(id)
                .map(course -> {
                    int indexOfCourseToDelete = fakeDatabase.indexOf(course);
                    if(indexOfCourseToDelete > 0){  // če nč ne najdemo je -1
                        fakeDatabase.set(indexOfCourseToDelete, new Course(id, courseChanged.getCourseName(), courseChanged.getDescription()));
                        return 1;
                    }
                    return 0;   // --> v bazi ni tega coursa
                })
                .orElse(0);
    }
}



