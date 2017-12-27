package com.isle.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by 61066 on 2017/12/27.
 */
@Controller
@RequestMapping("/")
public class HomeController {

    /**
     * 进入主页面
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model) {
        return "home";
    }

}
