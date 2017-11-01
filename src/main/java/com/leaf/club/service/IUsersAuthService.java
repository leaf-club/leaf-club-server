package com.leaf.club.service;

import com.leaf.club.model.UsersAuth;

/**
 * @author LL
 */
public interface IUsersAuthService {

    /**
     * 根据id获取用户授权
     * @param id
     * @return
     */
    UsersAuth getUsersAuthById(int id);
}