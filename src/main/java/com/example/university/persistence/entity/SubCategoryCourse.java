package com.example.university.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "sub_category_course")
public class SubCategoryCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    private SubCategory subCategory;

    @ManyToOne
    private Course course;

    public SubCategoryCourse() {
    }

    public SubCategoryCourse(Integer id, SubCategory subCategory, Course course) {
        this.id = id;
        this.subCategory = subCategory;
        this.course = course;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
