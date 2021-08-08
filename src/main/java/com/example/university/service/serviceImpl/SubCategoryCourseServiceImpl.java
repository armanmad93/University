package com.example.university.service.serviceImpl;

import com.example.university.persistence.entity.SubCategoryCourse;
import com.example.university.rest.model.subcategorycourse.RequestSubCategoryCourse;

import java.util.List;

public interface SubCategoryCourseServiceImpl {

    SubCategoryCourse create(RequestSubCategoryCourse request);

    SubCategoryCourse read(Integer id);

    List<SubCategoryCourse> readAll();

    SubCategoryCourse update(RequestSubCategoryCourse request, Integer id);

    Boolean delete(Integer id);
}
