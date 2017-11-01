package com.leaf.club.service;

import com.leaf.club.model.Blogs;

/**
 * @author LL
 */
public interface IBlogsService {

    /**
     * 根据id获取博文
     * @param id
     * @return
     */
    Blogs getBlogsById(int id);
}