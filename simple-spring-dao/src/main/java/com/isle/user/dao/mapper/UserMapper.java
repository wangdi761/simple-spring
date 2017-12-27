package com.isle.user.dao.mapper;

import com.isle.user.dao.domain.User;

import java.util.List;

/**
 * Created by 61066 on 2017/12/27.
 */
public interface UserMapper {

    List<User> findUsers(User user);

}
