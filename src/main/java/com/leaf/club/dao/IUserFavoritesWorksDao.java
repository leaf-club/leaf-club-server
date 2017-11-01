package com.leaf.club.dao;

import com.leaf.club.model.UserFavoritesWorks;

/**
 * @author LL
 */
public interface IUserFavoritesWorksDao {

    /**
     * 根据id查询用户最喜爱的作品
     * @param id
     * @return
     */
    UserFavoritesWorks getUserFavoritesWorksById(int id);
}