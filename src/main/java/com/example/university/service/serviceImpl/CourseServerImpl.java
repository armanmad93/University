package com.example.university.service.serviceImpl;

import com.example.university.persistence.entity.Course;
import com.example.university.rest.model.course.RequestCourse;

import java.util.List;

public interface CourseServerImpl {

    Course create(RequestCourse requestCourse);

    Course read(Integer id);

    List<Course> readAll();

    Course update(RequestCourse requestCourse, Integer id);

    Boolean delete(Integer id);
}
