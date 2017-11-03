package com.leaf.club.service.impl;

import com.leaf.club.dao.IUserDao;
import com.leaf.club.model.User;
import com.leaf.club.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xiechao
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    private static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private IUserDao userDao;

    @Override
    public User getUserById(int id) {
        log.info("查询的用户id为{}", id);
        User user = null;
        try {
            user = userDao.getUserById(id);
        } catch (Exception e) {
            log.error("数据库查询异常");
            return user;
        }
        log.info("查询到的用户信息为{}",user.toString());
        return user;
    }
}
