package com.leaf.club.service.impl;

import com.leaf.club.dao.IUserDao;
import com.leaf.club.model.User;
import com.leaf.club.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xiechao
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }
}
