package com.example.university.rest.model.subcategory;

import com.example.university.rest.model.category.ResponseCategory;

public class ResponseSubCategory {

    private Integer id;
    private ResponseCategory category;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ResponseCategory getCategory() {
        return category;
    }

    public void setCategory(ResponseCategory category) {
        this.category = category;
    }
}
