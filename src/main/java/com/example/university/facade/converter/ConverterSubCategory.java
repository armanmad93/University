package com.example.university.facade.converter;

import com.example.university.anotation.Convert;
import com.example.university.persistence.entity.SubCategory;
import com.example.university.rest.model.category.ResponseCategory;
import com.example.university.rest.model.subcategory.ResponseSubCategory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Convert
public class ConverterSubCategory {

    private final ConverterCategory converterCategory;

    @Autowired
    public ConverterSubCategory(ConverterCategory converterCategory) {
        this.converterCategory = converterCategory;
    }

    public ResponseSubCategory subCategoryConvertToResponseSubCategory(SubCategory subCategory) {

        ResponseSubCategory responseSubCategory = new ResponseSubCategory();
        responseSubCategory.setId(subCategory.getId());
        ResponseCategory responseCategory = converterCategory
                .CategoryConvertToResponseCategory(subCategory.getCategory());
        responseSubCategory.setCategory(responseCategory);

        return responseSubCategory;
    }

    public List<ResponseSubCategory> SubCategoriesConvertToResponseSubCategories(List<SubCategory> subCategories) {
        return subCategories
                .stream()
                .map(this::subCategoryConvertToResponseSubCategory)
                .collect(Collectors.toList());
    }
}
