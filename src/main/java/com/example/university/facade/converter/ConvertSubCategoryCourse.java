package com.example.university.facade.converter;

import com.example.university.anotation.Convert;
import com.example.university.persistence.entity.SubCategoryCourse;
import com.example.university.rest.model.subcategorycourse.ResponseSubCategoryCourse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Convert
public class ConvertSubCategoryCourse {

    private final ConverterSubCategory converterSubCategory;
    private final ConverterCourse converterCourse;

    @Autowired
    public ConvertSubCategoryCourse(ConverterSubCategory converterSubCategory, ConverterCourse converterCourse) {
        this.converterSubCategory = converterSubCategory;
        this.converterCourse = converterCourse;
    }

    public ResponseSubCategoryCourse subCategoryCourseConvertToResponseSubCategoryCourse(SubCategoryCourse subCategoryCourse) {
        ResponseSubCategoryCourse response = new ResponseSubCategoryCourse();

        response.setId(subCategoryCourse.getId());
        response
                .setCourse(converterCourse
                        .CourseConvertToResponseCourse(subCategoryCourse
                                .getCourse()));
        response
                .setResponseSubCategory(converterSubCategory
                        .subCategoryConvertToResponseSubCategory(subCategoryCourse
                                .getSubCategory()));
        return response;
    }

    public List<ResponseSubCategoryCourse> subCategoryCoursesConvertToResponseSubCategoryCourses(List<SubCategoryCourse> subCategoryCourses){
        return subCategoryCourses
                .stream()
                .map(this::subCategoryCourseConvertToResponseSubCategoryCourse)
                .collect(Collectors.toList());
    }


}
