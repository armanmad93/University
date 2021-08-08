package com.example.university.facade.converter;

import com.example.university.anotation.Convert;
import com.example.university.persistence.entity.Course;
import com.example.university.rest.model.course.ResponseCourse;

import java.util.List;
import java.util.stream.Collectors;

@Convert
public class ConverterCourse {

    public ResponseCourse CourseConvertToResponseCourse(Course course) {
        ResponseCourse responseCourse = new ResponseCourse();

        responseCourse.setName(course.getName());
        responseCourse.setPrice(course.getPrice());

        return responseCourse;
    }

    public List<ResponseCourse> CoursesConvertToResponseCourses(List<Course> courses) {

        return courses
                .stream()
                .map(each -> CourseConvertToResponseCourse(each))
                .collect(Collectors.toList());
    }
}
