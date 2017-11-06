package com.leaf.club.controller;

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

import java.util.HashMap;
import java.util.Map;

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
    public Map<String, Object> saveBlog(@RequestBody Blog blog){
        log.info("保存文章的前台数据：",blog);
        int id = -1;
        Map<String,Object> result = new HashMap<>();
        try {
            id = blogService.saveBlog(blog);
            log.info("保存的文章的id为：",id);
            result.put("id",id);
            result.put("code",200);
            result.put("msg","保存成功");
            return result;
        } catch (Exception e){
            System.out.println(e);
            log.error("保存文章出错：");
        }
        result.put("code",500);
        result.put("msg","保存失败");
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
    public Map<String,Object> praiseBlog(@PathVariable("id") int id){
        Map<String,Object> result = new HashMap<>();
        Boolean res = false;
        try {
            res = blogService.praiseBlog(id);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        if(res){
            result.put("code",200);
            result.put("msg","点赞成功");
        }else{
            result.put("code",500);
            result.put("code","点赞失败");
        }
        return result;
    }

    @RequestMapping(value = "/readBlog/{id}")
    @ResponseBody
    public Blog readBlog(@PathVariable("id") int id){
        Blog blog = null;
        try {
            blog = new Blog();
            blog = blogService.getBlogById(id);
            blogService.readBlogCount(id);            //可以整合成只操作一次数据库
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return blog;
    }

    @RequestMapping(value = "/reWriteBlog/{id}")
    @ResponseBody
    public Map<String,Object> reWriteBlog(@PathVariable("id") int id){
        Map<String,Object> result = new HashMap<>();
        String source = null;
        try {
            source = blogService.getBlogSourceById(id);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        if(source != null && !"".equals(source)){
            result.put("source",source);
            result.put("code",200);
        }else{
            result.put("code",500);
        }
        return result;
    }

}
