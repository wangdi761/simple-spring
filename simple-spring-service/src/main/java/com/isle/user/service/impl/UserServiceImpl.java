package com.isle.user.service.impl;

import com.isle.user.dao.domain.User;
import com.isle.user.dao.mapper.UserMapper;
import com.isle.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 61066 on 2017/12/27.
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findUsers(User user) {
        return userMapper.findUsers(user);
    }

}
