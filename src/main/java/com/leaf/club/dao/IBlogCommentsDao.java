package com.leaf.club.dao;

import com.leaf.club.model.BlogComments;

import java.util.Map;

/**
 * @author LL
 */
public interface IBlogCommentsDao {

    /**
     * 根据id查询博文评论
     * @param id
     * @return
     */
    BlogComments getBlogCommentsById(int id);

    /**
     * 评论博文
     * @param map
     * @return
     */
    int commentBlog(Map<String, Object> map);
}