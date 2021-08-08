package com.example.university.facade;

import com.example.university.anotation.Facade;
import com.example.university.facade.converter.ConverterCourse;
import com.example.university.persistence.entity.Course;
import com.example.university.rest.model.course.RequestCourse;
import com.example.university.rest.model.course.ResponseCourse;
import com.example.university.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Facade
public class CourseFacade {

    private final CourseService courseService;
    private final ConverterCourse converter;

    @Autowired
    public CourseFacade(CourseService courseService, ConverterCourse converter) {
        this.courseService = courseService;
        this.converter = converter;
    }

    public ResponseCourse create(RequestCourse requestCourse) {
        Course course = courseService.create(requestCourse);
        ResponseCourse responseCourse = converter.CourseConvertToResponseCourse(course);
        return responseCourse;
    }

    public ResponseCourse read(Integer id) {
        Course course = courseService.read(id);
        ResponseCourse responseCourse = converter.CourseConvertToResponseCourse(course);
        return responseCourse;
    }

    public List<ResponseCourse> readAll() {
        List<Course> courseList = courseService.readAll();
        List<ResponseCourse> responseCourses = converter.CoursesConvertToResponseCourses(courseList);
        return responseCourses;
    }

    public ResponseCourse update(RequestCourse requestCourse, Integer id) {
        Course course = courseService.update(requestCourse, id);
        ResponseCourse responseCourse = converter.CourseConvertToResponseCourse(course);
        return responseCourse;
    }

    public Boolean delete(Integer id) {
        return courseService.delete(id);
    }


}
