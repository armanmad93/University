package com.example.university.facade.converter;

import com.example.university.anotation.Convert;
import com.example.university.persistence.entity.Category;
import com.example.university.rest.model.category.ResponseCategory;

import java.util.List;
import java.util.stream.Collectors;

@Convert
public class ConverterCategory {

    public ResponseCategory CategoryConvertToResponseCategory(Category category) {
        ResponseCategory responseCategory = new ResponseCategory();
        responseCategory.setName(category.getName());
        return responseCategory;
    }

    public List<ResponseCategory> CategoriesConvertToResponseCategories(List<Category> categories) {

        return categories
                .stream()
                .map(this::CategoryConvertToResponseCategory)
                .collect(Collectors.toList());
    }
}
