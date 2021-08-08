package com.example.university.facade;

import com.example.university.anotation.Facade;
import com.example.university.facade.converter.ConverterCategory;
import com.example.university.persistence.entity.Category;
import com.example.university.service.CategoryService;
import com.example.university.rest.model.category.RequestCategory;
import com.example.university.rest.model.category.ResponseCategory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Facade
public class CategoryFacade {

    private final CategoryService categoryService;
    private final ConverterCategory converterCategory;

    @Autowired
    public CategoryFacade(CategoryService categoryService, ConverterCategory converterCategory) {
        this.categoryService = categoryService;
        this.converterCategory = converterCategory;
    }

    public ResponseCategory create(RequestCategory requestCategory) {
        Category category = categoryService.create(requestCategory);
        ResponseCategory responseCategory = converterCategory.CategoryConvertToResponseCategory(category);
        return responseCategory;
    }

    public ResponseCategory read(Integer id) {
        Category category = categoryService.read(id);
        ResponseCategory responseCategory = converterCategory.CategoryConvertToResponseCategory(category);
        return responseCategory;
    }

    public List<ResponseCategory> readAll() {
        List<Category> categories = categoryService.readAll();
        List<ResponseCategory> responseCategories = converterCategory.CategoriesConvertToResponseCategories(categories);
        return responseCategories;
    }

    public ResponseCategory update(RequestCategory requestCategory, Integer id) {
        Category category = categoryService.update(requestCategory, id);
        ResponseCategory responseCategory = converterCategory.CategoryConvertToResponseCategory(category);
        return responseCategory;
    }

    public Boolean delete(Integer id) {
        return categoryService.delete(id);
    }

}
