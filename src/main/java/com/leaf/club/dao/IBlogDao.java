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

    /**
     * 博文点赞
     * @param id
     * @return
     */
    int praiseBlog(int id);

    /**
     * 博文阅读量
     * @param id
     * @return
     */
    int readBlogCount(int id);

    /**
     * 获取文章的源码
     * @param id
     * @return
     */
    String getBlogSourceById(int id);
}