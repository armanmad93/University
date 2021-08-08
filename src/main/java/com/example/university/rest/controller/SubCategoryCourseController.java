package com.example.university.rest.controller;

import com.example.university.facade.SubCategoryCourseFacade;
import com.example.university.rest.model.subcategorycourse.RequestSubCategoryCourse;
import com.example.university.rest.model.subcategorycourse.ResponseSubCategoryCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubCategoryCourseController {

    private final SubCategoryCourseFacade subCategoryCourseFacade;

    @Autowired
    public SubCategoryCourseController(SubCategoryCourseFacade subCategoryCourseFacade) {
        this.subCategoryCourseFacade = subCategoryCourseFacade;
    }

    @PostMapping(value = "/createSubCategoryCourse")
    public ResponseEntity<ResponseSubCategoryCourse> create(@RequestBody RequestSubCategoryCourse request) {
        ResponseEntity<ResponseSubCategoryCourse> responseEntity = ResponseEntity
                .status(HttpStatus.CREATED)
                .body(subCategoryCourseFacade.create(request));
        return responseEntity;
    }

    @GetMapping(value = "/readSubCategoryCourse/{id}")
    public ResponseEntity<ResponseSubCategoryCourse> read(@PathVariable Integer id) {
        ResponseEntity<ResponseSubCategoryCourse> responseEntity = ResponseEntity
                .status(HttpStatus.OK)
                .body(subCategoryCourseFacade.read(id));
        return responseEntity;
    }

    @GetMapping(value = "/readAllSubCategoryCourse")
    public ResponseEntity<List<ResponseSubCategoryCourse>> readAll() {
        ResponseEntity<List<ResponseSubCategoryCourse>> responseEntity = ResponseEntity
                .status(HttpStatus.OK)
                .body(subCategoryCourseFacade.readAll());
        return responseEntity;
    }

    @PutMapping(value = "/updateSubCategoryCourse/{id}")
    public ResponseEntity<ResponseSubCategoryCourse> update(@RequestBody RequestSubCategoryCourse request
            , @PathVariable Integer id) {
        ResponseEntity<ResponseSubCategoryCourse> responseEntity = ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(subCategoryCourseFacade.update(request, id));
        return responseEntity;
    }

    @DeleteMapping(value = "/deleteSubCategoryCourse/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id) {
        ResponseEntity<Boolean> responseEntity = ResponseEntity
                .status(HttpStatus.OK)
                .body(subCategoryCourseFacade.delete(id));
        return responseEntity;
    }
}
