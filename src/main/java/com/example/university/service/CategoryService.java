package com.example.university.service;

import com.example.university.persistence.entity.Category;
import com.example.university.persistence.repository.CategoryRepository;
import com.example.university.rest.model.category.RequestCategory;
import com.example.university.service.serviceImpl.CategoryServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements CategoryServiceImpl {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category create(RequestCategory requestCategory) {
        Category category = build(requestCategory);
        categoryRepository.save(category);
        return category;
    }

    public Category read(Integer id) {
        return categoryRepository.getById(id);
    }

    public List<Category> readAll() {
        return categoryRepository.findAll();
    }

    public Category update(RequestCategory requestCategory, Integer id) {
        Category category = categoryRepository.getById(id);
        category.setName(requestCategory.getName());
        categoryRepository.save(category);
        return category;
    }

    public Boolean delete(Integer id) {
        categoryRepository.deleteById(id);
        return !categoryRepository.existsById(id);
    }

    private Category build(RequestCategory requestCategory) {

        Category category = new Category();
        category.setName(requestCategory.getName());

        return category;
    }

}
