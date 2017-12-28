package com.isle.student.service.impl;

import com.isle.student.dao.document.Student;
import com.isle.student.dao.mongo.StudentRepository;
import com.isle.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 61066 on 2017/12/28.
 */
@Service("studentService")
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> findByName(String name) {
        return studentRepository.findByName(name);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

}
