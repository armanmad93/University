package com.example.university.service;

import com.example.university.persistence.entity.SubCategoryCourse;
import com.example.university.persistence.repository.SubCategoryCourseRepository;
import com.example.university.rest.model.subcategorycourse.RequestSubCategoryCourse;
import com.example.university.service.serviceImpl.SubCategoryCourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubCategoryCourseService implements SubCategoryCourseServiceImpl {

    private final SubCategoryCourseRepository subCategoryCourseRepository;
    private final SubCategoryService subCategoryService;
    private final CourseService courseService;

    @Autowired
    public SubCategoryCourseService(SubCategoryCourseRepository subCategoryCourseRepository
            , SubCategoryService subCategoryService
            , CourseService courseService) {
        this.subCategoryCourseRepository = subCategoryCourseRepository;
        this.subCategoryService = subCategoryService;
        this.courseService = courseService;
    }

    @Override
    public SubCategoryCourse create(RequestSubCategoryCourse request) {
        SubCategoryCourse subCategoryCourse = build(request);
        subCategoryCourseRepository.save(subCategoryCourse);
        return subCategoryCourse;
    }

    @Override
    public SubCategoryCourse read(Integer id) {
        return subCategoryCourseRepository.getById(id);
    }

    @Override
    public List<SubCategoryCourse> readAll() {
        return subCategoryCourseRepository.findAll();
    }

    @Override
    public SubCategoryCourse update(RequestSubCategoryCourse request, Integer id) {
        SubCategoryCourse subCategoryCourse = read(id);
        subCategoryCourse.setCourse(courseService.read(request.getCourseId()));
        subCategoryCourse.setSubCategory(subCategoryService.read(request.getSubCategoryId()));
        subCategoryCourseRepository.save(subCategoryCourse);
        return subCategoryCourse;
    }

    @Override
    public Boolean delete(Integer id) {
        subCategoryCourseRepository.deleteById(id);
        return !subCategoryCourseRepository.existsById(id);
    }

    private SubCategoryCourse build(RequestSubCategoryCourse request) {
        SubCategoryCourse subCategoryCourse = new SubCategoryCourse();

        subCategoryCourse.setSubCategory(subCategoryService.read(request.getSubCategoryId()));
        subCategoryCourse.setCourse(courseService.read(request.getCourseId()));

        return subCategoryCourse;
    }
}
