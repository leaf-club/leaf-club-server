package com.leaf.club.service;

import com.leaf.club.model.BlogReplies;

/**
 * @author LL
 */
public interface IBlogRepliesService {

    /**
     * 根据id获取博文回复
     * @param id
     * @return
     */
    BlogReplies getBlogRepliesById(int id);
}