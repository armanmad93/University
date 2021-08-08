package com.example.university.rest.model.subcategorycourse;

import com.example.university.rest.model.category.ResponseCategory;
import com.example.university.rest.model.course.ResponseCourse;
import com.example.university.rest.model.subcategory.ResponseSubCategory;

public class ResponseSubCategoryCourse {

    private Integer id;
    private ResponseSubCategory responseSubCategory;
    private ResponseCourse course;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ResponseSubCategory getResponseSubCategory() {
        return responseSubCategory;
    }

    public void setResponseSubCategory(ResponseSubCategory responseSubCategory) {
        this.responseSubCategory = responseSubCategory;
    }

    public ResponseCourse getCourse() {
        return course;
    }

    public void setCourse(ResponseCourse course) {
        this.course = course;
    }
}
