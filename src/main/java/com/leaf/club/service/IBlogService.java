package com.leaf.club.service;

import com.leaf.club.model.Blog;
import org.apache.ibatis.annotations.Param;

/**
 * @author LL
 */
public interface IBlogService {

    /**
     * 根据id获取博文
     * @param id
     * @return
     */
    Blog getBlogById(int id);

    /**
     * 保存文章
     * @param blog
     * @return
     */
    int saveBlog(@Param("blog") Blog blog);

    /**
     * 博文的点赞
     * @param id
     * @return
     */
    Boolean praiseBlog(int id);

    /**
     * 博文的阅读量
     * @param id
     * @return
     */
    Boolean readBlogCount(int id);

    /**
     * 获取博文的内容
     * @param id
     * @return
     */
    String getBlogSourceById(int id);
}