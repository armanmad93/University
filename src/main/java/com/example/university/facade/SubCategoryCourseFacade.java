package com.example.university.facade;

import com.example.university.anotation.Facade;
import com.example.university.facade.converter.ConvertSubCategoryCourse;
import com.example.university.persistence.entity.SubCategoryCourse;
import com.example.university.rest.model.subcategorycourse.RequestSubCategoryCourse;
import com.example.university.rest.model.subcategorycourse.ResponseSubCategoryCourse;
import com.example.university.service.SubCategoryCourseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Facade
public class SubCategoryCourseFacade {

    private final SubCategoryCourseService service;
    private final ConvertSubCategoryCourse convert;

    @Autowired
    public SubCategoryCourseFacade(SubCategoryCourseService service, ConvertSubCategoryCourse convert) {
        this.service = service;
        this.convert = convert;
    }

    public ResponseSubCategoryCourse create(RequestSubCategoryCourse request) {
        SubCategoryCourse subCategoryCourse = service.create(request);
        ResponseSubCategoryCourse responseSubCategoryCourse = convert
                .subCategoryCourseConvertToResponseSubCategoryCourse(subCategoryCourse);
        return responseSubCategoryCourse;
    }

    public ResponseSubCategoryCourse read(Integer id) {
        SubCategoryCourse subCategoryCourse = service.read(id);
        ResponseSubCategoryCourse responseSubCategoryCourse = convert
                .subCategoryCourseConvertToResponseSubCategoryCourse(subCategoryCourse);
        return responseSubCategoryCourse;
    }

    public List<ResponseSubCategoryCourse> readAll() {
        List<SubCategoryCourse> subCategoryCourses = service.readAll();
        List<ResponseSubCategoryCourse> responseSubCategoryCourses = convert
                .subCategoryCoursesConvertToResponseSubCategoryCourses(subCategoryCourses);
        return responseSubCategoryCourses;
    }

    public ResponseSubCategoryCourse update(RequestSubCategoryCourse request, Integer id) {
        SubCategoryCourse subCategoryCourse = service.update(request, id);
        ResponseSubCategoryCourse responseSubCategoryCourse = convert
                .subCategoryCourseConvertToResponseSubCategoryCourse(subCategoryCourse);
        return responseSubCategoryCourse;
    }

    public Boolean delete(Integer id) {
        return service.delete(id);
    }

}
