package com.isle.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 61066 on 2017/12/27.
 */
@Controller
public class FormController {

    @RequestMapping("/{formName}")
    public String loginForm(@PathVariable String formName) {
        return formName;
    }

}
