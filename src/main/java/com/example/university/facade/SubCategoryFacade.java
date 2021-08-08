package com.example.university.facade;

import com.example.university.anotation.Facade;
import com.example.university.facade.converter.ConverterSubCategory;
import com.example.university.persistence.entity.SubCategory;
import com.example.university.rest.model.subcategory.RequestSubCategory;
import com.example.university.rest.model.subcategory.ResponseSubCategory;
import com.example.university.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Facade
public class SubCategoryFacade {

    private final SubCategoryService subCategoryService;
    private final ConverterSubCategory converterSubCategory;

    @Autowired
    public SubCategoryFacade(SubCategoryService subCategoryService, ConverterSubCategory converterSubCategory) {
        this.subCategoryService = subCategoryService;
        this.converterSubCategory = converterSubCategory;
    }

    public ResponseSubCategory create(RequestSubCategory requestSubCategory) {

        SubCategory subCategory = subCategoryService
                .create(requestSubCategory);
        ResponseSubCategory responseSubCategory = converterSubCategory
                .subCategoryConvertToResponseSubCategory(subCategory);

        return responseSubCategory;

    }

    public ResponseSubCategory read(Integer id) {

        SubCategory subCategory = subCategoryService.read(id);
        ResponseSubCategory responseSubCategory = converterSubCategory
                .subCategoryConvertToResponseSubCategory(subCategory);

        return responseSubCategory;

    }

    public List<ResponseSubCategory> readAll() {

        List<SubCategory> subCategories = subCategoryService.readAll();
        List<ResponseSubCategory> responseSubCategories = converterSubCategory
                .SubCategoriesConvertToResponseSubCategories(subCategories);

        return responseSubCategories;

    }

    public ResponseSubCategory update(RequestSubCategory requestSubCategory, Integer id) {

        SubCategory subCategory = subCategoryService.update(requestSubCategory, id);
        ResponseSubCategory responseSubCategory = converterSubCategory
                .subCategoryConvertToResponseSubCategory(subCategory);

        return responseSubCategory;

    }

    public Boolean delete(Integer id) {
        return subCategoryService.delete(id);
    }

}
