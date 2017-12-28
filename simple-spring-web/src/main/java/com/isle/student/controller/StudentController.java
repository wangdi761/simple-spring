package com.isle.student.controller;

import com.isle.student.dao.document.Student;
import com.isle.student.service.StudentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by 61066 on 2017/12/28.
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public String page() {
        return "student/studentPage";
    }


    @RequestMapping(value = "/findStudents", method = RequestMethod.GET)
    public @ResponseBody List<Student> findStudents() {
        List<Student> students = studentService.findAll();
        return students;
    }

}
