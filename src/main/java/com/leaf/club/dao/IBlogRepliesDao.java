package com.leaf.club.dao;

import com.leaf.club.model.BlogReplies;

/**
 * @author LL
 */
public interface IBlogRepliesDao {

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    BlogReplies getBlogRepliesById(int id);
}