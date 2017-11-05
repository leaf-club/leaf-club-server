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


@Controller
@RequestMapping(value = "/article")
public class BlogController {
//    private static Logger log = LoggerFactory.getLogger(BlogsController.class);

    @Autowired
    private IBlogService blogService;

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> saveBlog(@RequestBody Blog blog){
//        log.info("保存文章的前台数据：",blog);
        int id = -1;
        Map<String,Object> result = new HashMap<>();
        try {
            id = blogService.saveBlog(blog);
//            log.info("保存的文章的id为：",id);
            result.put("id",id);
            result.put("code",200);
            result.put("msg","保存成功");
            return result;
        } catch (Exception e){
            System.out.println(e);
//            log.error("保存文章出错：", e.getMessage());
        }
        result.put("code",500);
        result.put("msg","保存失败");
        return result;
    }

    @RequestMapping(value = "/search/{id}")
    @ResponseBody
    public Blog getBlogById(@PathVariable("id") int id){
        Blog blog = null;
        blog = blogService.getBlogById(id);
        return blog;
    }
}
