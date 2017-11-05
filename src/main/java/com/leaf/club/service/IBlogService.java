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
}