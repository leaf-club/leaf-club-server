package com.leaf.club.service;

import com.leaf.club.model.UserFavoritesBlogs;

import java.util.Map;

/**
 * @author LL
 */
public interface IUserFavoritesBlogsService {

    /**
     * 根据id获取用户最喜爱的博文
     * @param id
     * @return
     */
    UserFavoritesBlogs getUserFavoritesBlogsById(int id);

    Map<String,Object> favoritesBlog(Map<String,Object> map);

}