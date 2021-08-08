package com.example.university.service;

import com.example.university.persistence.entity.SubCategory;
import com.example.university.persistence.repository.SubCategoryRepository;
import com.example.university.rest.model.subcategory.RequestSubCategory;
import com.example.university.service.serviceImpl.SubCategoryImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubCategoryService implements SubCategoryImpl {

    private final SubCategoryRepository subCategoryRepository;
    private final CategoryService categoryService;

    public SubCategoryService(SubCategoryRepository subCategoryRepository, CategoryService categoryService) {
        this.subCategoryRepository = subCategoryRepository;
        this.categoryService = categoryService;
    }

    @Override
    public SubCategory create(RequestSubCategory requestSubCategory) {
        SubCategory subCategory = build(requestSubCategory);
        subCategoryRepository.save(subCategory);
        return subCategory;
    }

    @Override
    public SubCategory read(Integer id) {
        return subCategoryRepository.getById(id);
    }

    @Override
    public List<SubCategory> readAll() {
        return subCategoryRepository.findAll();
    }

    @Override
    public SubCategory update(RequestSubCategory requestSubCategory, Integer id) {

        SubCategory subCategory = read(id);
        subCategory.setName(requestSubCategory.getName());
        subCategoryRepository.save(subCategory);

        return subCategory;

    }

    @Override
    public Boolean delete(Integer id) {
        subCategoryRepository.deleteById(id);
        return !subCategoryRepository.existsById(id);
    }

    private SubCategory build(RequestSubCategory requestSubCategory) {
        SubCategory subCategory = new SubCategory();

        subCategory.setName(requestSubCategory.getName());
        subCategory.setCategory(categoryService.read(requestSubCategory.getCategoryId()));

        return subCategory;
    }
}
