package com.demo.service.imp;


import com.demo.dao.dao;
import com.demo.entity.User;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @desc用户service
 * @Author wangsh
 * @date 2018/5/5 14:01
 */
@Service
public class UserServiceImp implements UserService {

    @Autowired
    private dao userDao;

    @Override
    public int insert(User user) {
//    测试事物是否起作用，如果没有保存成功，则事物生效
//    int a = 1/0;
        return userDao.insert(user);
    }

    @Override
    public int deleteById(Integer id) {
        return userDao.deleteById(id);
    }

    @Override
    public int update(User user) {
        return userDao.update(user);
    }

    @Override
    public User getById(Integer id) {
        return userDao.getById(id);
    }

}
