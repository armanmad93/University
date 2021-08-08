package com.example.university.rest.controller;

import com.example.university.facade.SubCategoryFacade;
import com.example.university.rest.model.subcategory.RequestSubCategory;
import com.example.university.rest.model.subcategory.ResponseSubCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubCategoryController {

    private final SubCategoryFacade subCategoryFacade;

    @Autowired
    public SubCategoryController(SubCategoryFacade subCategoryFacade) {
        this.subCategoryFacade = subCategoryFacade;
    }

    @PostMapping(value = "/createSubCategory")
    public ResponseEntity<ResponseSubCategory> create(@RequestBody RequestSubCategory requestSubCategory) {

        ResponseEntity<ResponseSubCategory> responseEntity = ResponseEntity
                .status(HttpStatus.CREATED)
                .body(subCategoryFacade.create(requestSubCategory));

        return responseEntity;
    }

    @GetMapping(value = "/readSubCategory/{id}")
    public ResponseEntity<ResponseSubCategory> read(@PathVariable Integer id) {

        ResponseEntity<ResponseSubCategory> responseEntity = ResponseEntity
                .status(HttpStatus.CREATED)
                .body(subCategoryFacade.read(id));

        return responseEntity;

    }

    @GetMapping(value = "/readAllSubCategory")
    public ResponseEntity<List<ResponseSubCategory>> readAll() {

        ResponseEntity<List<ResponseSubCategory>> responseEntity = ResponseEntity
                .status(HttpStatus.CREATED)
                .body(subCategoryFacade.readAll());

        return responseEntity;

    }

    @PutMapping(value = "/updateSubCategory/{id}")
    public ResponseEntity<ResponseSubCategory> update(@RequestBody RequestSubCategory requestSubCategory, @PathVariable Integer id) {

        ResponseEntity<ResponseSubCategory> responseEntity = ResponseEntity
                .status(HttpStatus.CREATED)
                .body(subCategoryFacade.update(requestSubCategory, id));

        return responseEntity;

    }

    @DeleteMapping(value = "deleteSubCategory/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id) {

        ResponseEntity<Boolean> responseEntity = ResponseEntity
                .status(HttpStatus.CREATED)
                .body(subCategoryFacade.delete(id));

        return responseEntity;

    }

}
