package com.leaf.club.service;

import com.leaf.club.model.BlogComments;

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
}