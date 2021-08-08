package com.example.university.rest.controller;

import com.example.university.facade.CourseFacade;
import com.example.university.rest.model.course.RequestCourse;
import com.example.university.rest.model.course.ResponseCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    private final CourseFacade courseFacade;

    @Autowired
    public CourseController(CourseFacade courseFacade) {
        this.courseFacade = courseFacade;
    }

    @PostMapping(value = "/createCourse")
    public ResponseEntity<ResponseCourse> create(@RequestBody RequestCourse requestCourse) {
        ResponseEntity<ResponseCourse> responseEntity = ResponseEntity
                .status(HttpStatus.CREATED)
                .body(courseFacade.create(requestCourse));
        return responseEntity;
    }

    @GetMapping(value = "/readCourse/{id}")
    public ResponseEntity<ResponseCourse> read(@PathVariable Integer id) {
        ResponseEntity<ResponseCourse> responseEntity = ResponseEntity
                .status(HttpStatus.OK)
                .body(courseFacade.read(id));

        return responseEntity;
    }

    @GetMapping(value = "/readAll")
    public ResponseEntity<List<ResponseCourse>> readAll() {
        ResponseEntity<List<ResponseCourse>> responseEntity = ResponseEntity
                .status(HttpStatus.OK)
                .body(courseFacade.readAll());
        return responseEntity;
    }

    @PutMapping(value = "/updateCourse/{id}")
    public ResponseEntity<ResponseCourse> update(@RequestBody RequestCourse requestCourse, @PathVariable Integer id) {
        ResponseEntity<ResponseCourse> responseEntity = ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(courseFacade.update(requestCourse, id));
        return responseEntity;
    }

    @DeleteMapping(value = "/deleteCourse/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id) {
        ResponseEntity<Boolean> responseEntity = ResponseEntity
                .status(HttpStatus.OK)
                .body(courseFacade.delete(id));
        return responseEntity;
    }
}
