package com.ycu.lgw.service.impl;

import com.ycu.lgw.model.User;
import com.ycu.lgw.repository.UserDao;
import com.ycu.lgw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserDao userDao;
    
    @Override
    public List<User> getUserList() {
        return this.userDao.findAll();
    }

    @Override
    public User findUserById(long id) {
        return this.userDao.findById(id);
    }

    @Override
    public void save(User user) {
        this.userDao.save(user);
    }

    @Override
    public void edit(User user) {
        this.userDao.save(user);
    }

    @Override
    public void delete(long id) {
        this.userDao.deleteById(id);
    }
}