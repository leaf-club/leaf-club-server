package com.leaf.club.dao;

import com.leaf.club.model.Blogs;

/**
 * @author LL
 */
public interface IBlogsDao {

    /**
     * 根据id查询博文
     * @param id
     * @return
     */
    Blogs getBlogsById(int id);
}