package com.leaf.club.dao;

import com.leaf.club.model.UsersAuth;

/**
 * @author LL
 */
public interface IUsersAuthDao {

    /**
     * 根据id查询用户授权
     * @param id
     * @return
     */
    UsersAuth getUsersAuthById(int id);
}