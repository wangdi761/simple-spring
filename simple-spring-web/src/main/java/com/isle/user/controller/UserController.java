package com.isle.user.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.isle.common.utils.datagrid.EUDataGridResult;
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

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public String page() {
        return "user/userPage";
    }

    /**
     * 分页查询示例
     * @param user
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping(value = "/findUsers", method = RequestMethod.GET)
    public @ResponseBody EUDataGridResult<User> findUsers(User user, Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        List<User> users = userService.findUsers(user);
        PageInfo<User> pageInfo = new PageInfo<>(users);
        EUDataGridResult<User> result = new EUDataGridResult<>();
        result.setRows(users);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

}
