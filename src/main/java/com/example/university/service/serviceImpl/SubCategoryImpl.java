package com.example.university.service.serviceImpl;

import com.example.university.persistence.entity.SubCategory;
import com.example.university.rest.model.subcategory.RequestSubCategory;

import java.util.List;

public interface SubCategoryImpl {

    SubCategory create(RequestSubCategory requestSubCategory);

    SubCategory read(Integer id);

    List<SubCategory> readAll();

    SubCategory update(RequestSubCategory requestSubCategory, Integer id);

    Boolean delete(Integer id);

}
