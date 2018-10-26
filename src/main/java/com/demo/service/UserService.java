package com.demo.service;

import com.demo.entity.User;

public interface UserService {

    int insert(User user);

    int deleteById(Integer id);

    int update(User user);

    User getById(Integer id);
}
