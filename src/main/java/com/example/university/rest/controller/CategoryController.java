package com.example.university.rest.controller;

import com.example.university.facade.CategoryFacade;
import com.example.university.rest.model.category.RequestCategory;
import com.example.university.rest.model.category.ResponseCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    private final CategoryFacade categoryFacade;

    @Autowired
    public CategoryController(CategoryFacade categoryFacade) {
        this.categoryFacade = categoryFacade;
    }

    @PostMapping(value = "/createCategory")
    public ResponseEntity<ResponseCategory> create(@RequestBody RequestCategory requestCategory) {
        ResponseEntity<ResponseCategory> responseEntity = ResponseEntity
                .status(HttpStatus.CREATED)
                .body(categoryFacade.create(requestCategory));
        return responseEntity;
    }

    @GetMapping(value = "/readCategory/{id}")
    public ResponseEntity<ResponseCategory> read(@PathVariable Integer id) {
        ResponseEntity<ResponseCategory> responseEntity = ResponseEntity.
                status(HttpStatus.CREATED)
                .body(categoryFacade.read(id));

        return responseEntity;
    }

    @GetMapping(value = "/readAllCategory")
    public ResponseEntity<List<ResponseCategory>> readAll() {
        ResponseEntity<List<ResponseCategory>> listResponseEntity = ResponseEntity
                .status(HttpStatus.CREATED)
                .body(categoryFacade.readAll());
        return listResponseEntity;
    }

    @PutMapping(value = "/updateCategory/{id}")
    public ResponseEntity<ResponseCategory> update(@RequestBody RequestCategory requestCategory, @PathVariable Integer id) {
        ResponseEntity<ResponseCategory> responseEntity = ResponseEntity
                .status(HttpStatus.CREATED)
                .body(categoryFacade.update(requestCategory, id));

        return responseEntity;
    }

    @DeleteMapping(value = "/deleteCategory/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id) {
        ResponseEntity<Boolean> responseEntity = ResponseEntity
                .status(HttpStatus.CREATED)
                .body(categoryFacade.delete(id));

        return responseEntity;
    }

}
