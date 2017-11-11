package com.leaf.club.controller;

import com.alibaba.fastjson.JSON;
import com.leaf.club.model.Blog;
import com.leaf.club.service.IBlogService;
//import org.apache.taglibs.standard.lang.jstl.NullLiteral;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author xuzhiliang
 */
@Controller
@RequestMapping(value = "/article")
public class BlogController {
    private static Logger log = LoggerFactory.getLogger(BlogController.class);

    @Autowired
    private IBlogService blogService;

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> saveBlog(@RequestBody Map<String,Object> map){
        Blog blog = new Blog();
        if(map.get("userId") != null){
            blog.setBlogAuthorId((Integer)map.get("userId"));
        }
        if(map.get("htmlCode") != null) {
            blog.setBlogContent((String) map.get("htmlCode"));
        }
        if(map.get("abstract") != null){
            blog.setBlogExcerpt((String)map.get("abstract"));
        }
        if(map.get("mdCode") != null) {
            blog.setBlogSource((String) map.get("mdCode"));
        }
        if(map.get("status") != null) {
            blog.setBlogStatus((Integer) map.get("status"));
        }
        if(map.get("tag") != null) {
            blog.setBlogTag((String) map.get("tag"));
        }
        if(map.get("id") != null) {
            blog.setBlogType((Integer) map.get("id"));
        }
        if(map.get("title") != null) {
            blog.setBlogTitle((String) map.get("title"));
        }
        blog.setBlogCreateTime(System.currentTimeMillis());
        log.info("保存文章的前台数据：",blog);
        Map<String,Object> result = new HashMap<>(4);
        try {
            result = blogService.saveBlog(blog);
            return result;
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }


    @RequestMapping(value = "/search/{id}")
    @ResponseBody
    public Blog getBlogById(@PathVariable("id") int id){
        Blog blog = null;
        try {
            blog = blogService.getBlogById(id);
            blogService.readBlogCount(id);

        }catch (Exception e){
            log.error(e.getMessage());
        }
        return blog;
    }

    @RequestMapping(value = "/praiseBlog/{id}")
    @ResponseBody
    public Map<String,Object> praiseBlog(@RequestBody Map<String,Object> map){
        int id = 0;
        int userId = 0;
        if(map.get("id") != null){
            id = (int)map.get("id");
        }
        if(map.get("userId") != null){
            userId = (int)map.get("userId");
        }
        Map<String,Object> result = new HashMap<>();
        try {
            result = blogService.praiseBlog(id,userId);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "/readBlog/{id}")
    @ResponseBody
    public Map<String,Object> readBlog(@PathVariable("id") int id){
        Map<String,Object> result = new HashMap<>();
        try{
            result = blogService.readBlog(id);
        }catch (Exception e){
            e.printStackTrace();
            return result;
        }
        return result;
    }

    @RequestMapping(value = "/readAllBlog",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> readAllBlog(@RequestBody Map<String,Object> map){
        Map<String,Object> result = new HashMap<>();
        try{
            result = blogService.readAllBlogByPage(map);
        }catch (Exception e){
            e.printStackTrace();
            return result;
        }
        return result;
    }

    @RequestMapping(value = "/readTypeBlog",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> readTypeBlog(@RequestBody Map<String,Object> map){
        Map<String,Object> result = new HashMap<>();
        try{
            result = blogService.readAllBlogByPage(map);
        }catch (Exception e){
            e.printStackTrace();
            return result;
        }
        return result;
    }
}
