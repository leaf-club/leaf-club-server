package com.leaf.club.dao;

import com.leaf.club.model.Blog;

/**
 * @author LL
 */
public interface IBlogDao {

    /**
     * 根据id查询博文
     * @param id
     * @return
     */
    Blog getBlogById(int id);


    /**
     * 保存文章
     * @param blog
     * @return
     */
    int saveBlog( Blog blog);
}