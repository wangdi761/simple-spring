package com.isle.student.service;

import com.isle.student.dao.document.Student;

import java.util.List;

/**
 * Created by 61066 on 2017/12/28.
 */
public interface StudentService {

    List<Student> findByName(String name);

    List<Student> findAll();

}
