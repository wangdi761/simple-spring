package com.isle.user.controller;

import com.isle.user.dao.domain.User;
import com.isle.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by 61066 on 2017/12/27.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/findUsers", method = RequestMethod.GET)
    public @ResponseBody List<User> findUsers(User user) {
        return userService.findUsers(user);
    }

}
