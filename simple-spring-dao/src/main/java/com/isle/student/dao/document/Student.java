package com.isle.student.dao.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * Created by 61066 on 2017/12/28.
 */
@Document(collection = "students")
public class Student implements Serializable {

    private String id;

    private String name;

    private Integer age;

    private String email;

    private Float math;

    private Float chinese;

    private Float english;

    private String country;

    private Collection<Book> books = new LinkedHashSet<>();

    private String bookStr;

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Field("m")
    public Float getMath() {
        return math;
    }

    public void setMath(Float math) {
        this.math = math;
    }

    @Field("c")
    public Float getChinese() {
        return chinese;
    }

    public void setChinese(Float chinese) {
        this.chinese = chinese;
    }

    @Field("e")
    public Float getEnglish() {
        return english;
    }

    public void setEnglish(Float english) {
        this.english = english;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Collection<Book> getBooks() {
        return books;
    }

    public void setBooks(Collection<Book> books) {
        this.books = books;
    }

    @Transient
    public String getBookStr() {
        return bookStr;
    }

    public void setBookStr(String bookStr) {
        this.bookStr = bookStr;
    }
}
