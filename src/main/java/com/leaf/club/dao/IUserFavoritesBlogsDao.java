package com.leaf.club.dao;

import com.leaf.club.model.UserFavoritesBlogs;

/**
 * @author LL
 */
public interface IUserFavoritesBlogsDao {

    /**
     * 根据id查询用户最喜爱的博文
     * @param id
     * @return
     */
    UserFavoritesBlogs getUserFavoritesBlogsById(int id);
}