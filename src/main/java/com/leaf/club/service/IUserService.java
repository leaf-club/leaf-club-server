package com.leaf.club.service;

import com.leaf.club.model.User;

/**
 * @author xiechao
 */
public interface IUserService {

    /**
     * 根据id获取用户
     * @param id
     * @return
     */
    User getUserById(int id);
}
