package com.demo.dao;

import com.demo.entity.User;

public interface dao{

    int insert(User user);

    int deleteById(Integer id);

    int update(User user);

    User getById(Integer id);

}
