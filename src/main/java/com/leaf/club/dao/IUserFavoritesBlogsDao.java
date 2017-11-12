package com.leaf.club.dao;

import com.leaf.club.model.UserFavoritesBlogs;


import java.util.Map;

/**
 * @author LL
 */
public interface IUserFavoritesBlogsDao {

    /**
     * 根据id查询用户最喜爱的博文
     *
     * @param id
     * @return
     */
    UserFavoritesBlogs getUserFavoritesBlogsById(int id);

    /**
     * favorites_blog插入数据
     * @param map
     * @return
     */
    int favoritesBlogInsert(Map<String,Object> map);

    /**
     * 更新blogs的favorites_count
     * @param id
     * @return
     */
    int  favoritesBlogUpdate(int id);

    /**
     * 检测用户是否已经收藏
     * @param map
     * @return
     */
    Integer favoritesBlogSelect(Map<String,Object> map);

    /**
     * 取消收藏
     * @param map
     * @return
     */
    int favoritesBlogDelete(Map<String,Object> map);

    /**
     * blog的favorites_count--
     * @param id
     * @return
     */
    int favoritesBlogUpdateMinus(int id);
}