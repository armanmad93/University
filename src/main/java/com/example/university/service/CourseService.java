package com.example.university.service;

import com.example.university.persistence.entity.Course;
import com.example.university.persistence.repository.CourseRepository;
import com.example.university.rest.model.course.RequestCourse;
import com.example.university.service.serviceImpl.CourseServerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService implements CourseServerImpl {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course create(RequestCourse requestCourse) {
        Course course = build(requestCourse);
        courseRepository.save(course);
        return course;
    }

    @Override
    public Course read(Integer id) {
        return courseRepository.getById(id);
    }

    @Override
    public List<Course> readAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course update(RequestCourse requestCourse, Integer id) {
        Course course = courseRepository.getById(id);
        course.setName(requestCourse.getName());
        course.setPrice(requestCourse.getPrice());
        courseRepository.save(course);
        return course;
    }

    @Override
    public Boolean delete(Integer id) {
        courseRepository.deleteById(id);
        return !courseRepository.existsById(id);
    }

    private Course build(RequestCourse requestCourse) {
        Course course = new Course();

        course.setName(requestCourse.getName());
        course.setPrice(requestCourse.getPrice());

        return course;
    }
}
