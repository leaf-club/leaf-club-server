package com.leaf.club.dao;

import com.leaf.club.model.Blog;

import java.util.List;
import java.util.Map;

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

    int reSaveBlog( Blog blog);

    /**
     * 博文点赞
     * @param id,userId
     * @return
     */
    int praiseBlog(int id,int userId);

    /**
     * 博文阅读量
     * @param id
     * @return
     */
    int readBlogCount(int id);

    /**
     * 博文分页读取
     * @param map
     * @return
     */
    List<Map<String,Object>> readAllBlogByPage(Map<String,Object> map);

    /**
     * 博文分类读取
     * @param map
     * @return
     */
    List<Map<String,Object>> readTypeBlogByPage(Map<String,Object> map);

    List<Map<String,Object>> readAll(int count);

    Map<String,Object> readBlog(int id);

    List<Map<String,Object>> readAllByType(Map<String,Object> selectByType);

    /**
     * 收藏文章
     * @param id
     * @param userId
     * @return
     */
    int favoritesBlog(int id,int userId);
}