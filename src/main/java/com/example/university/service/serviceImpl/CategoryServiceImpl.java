package com.example.university.service.serviceImpl;

import com.example.university.persistence.entity.Category;
import com.example.university.rest.model.category.RequestCategory;

import java.util.List;

public interface CategoryServiceImpl {

    Category create(RequestCategory requestCategory);

    Category read(Integer id);

    List<Category> readAll();

    Category update(RequestCategory requestCategory, Integer id);

    Boolean delete(Integer id);

}
