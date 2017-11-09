package com.leaf.club.service;

import com.leaf.club.model.Blog;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

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
    Map<String,Object> saveBlog(@Param("blog") Blog blog);

    /**
     * 博文的点赞
     * @param id
     * @return
     */
    Map<String,Object> praiseBlog(int id);

    /**
     * 博文的阅读量
     * @param id
     * @return
     */
    Map<String,Object> readBlogCount(int id);

    /**
     * 分页读取全部博文
     * @param map
     * @return
     */
    List<Map<String,Object>> readAllBlogByPage(Map<String,Object> map);

    /**
     * 分页读取分类博文
     * @param map
     * @return
     */
    List<Map<String,Object>> readTypeBlogByPage(Map<String,Object> map);

    /**
     *读取博文
     * @param id
     * @return
     */
    Map<String,Object> readBlog(int id);
}