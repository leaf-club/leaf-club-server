package com.leaf.club.dao;

import com.leaf.club.model.User;

/**
 * @author xiechao
 */
public interface IUserDao {

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    User getUserById(int id);
}
