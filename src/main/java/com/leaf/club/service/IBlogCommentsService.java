package com.leaf.club.service;

import com.leaf.club.model.BlogComments;

import java.util.Map;

/**
 * @author LL
 */
public interface IBlogCommentsService {

    /**
     * 根据id获取博文评论
     * @param id
     * @return
     */
    BlogComments getBlogCommentsById(int id);

    /**
     * 评论博文
     * @
     * @return
     */

    Map<String,Object> commentBlog(Map<String, Object> map);
}