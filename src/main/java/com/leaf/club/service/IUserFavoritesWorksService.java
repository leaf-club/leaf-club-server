package com.leaf.club.service;

import com.leaf.club.model.UserFavoritesWorks;

/**
 * @author LL
 */
public interface IUserFavoritesWorksService {

    /**
     * 根据id获取用户最喜爱的作品
     * @param id
     * @return
     */
    UserFavoritesWorks getUserFavoritesWorksById(int id);
}