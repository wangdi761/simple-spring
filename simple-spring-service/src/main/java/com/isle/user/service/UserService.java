package com.isle.user.service;

import com.isle.user.dao.domain.User;

import java.util.List;
import java.util.Map;

/**
 * Created by 61066 on 2017/12/27.
 */
public interface UserService {

    List<User> findUsers(User user);

}
