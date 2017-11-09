package com.leaf.club.controller;

import com.leaf.club.service.IBlogCommentsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("blogComment")
public class BlogCommentsController {

    private static Logger log = LoggerFactory.getLogger(BlogCommentsController.class);

    @Autowired
    IBlogCommentsService blogCommentsService;

    @RequestMapping(value = "comment",method = RequestMethod.POST)
    @ResponseBody
     public Map<String,Object> blogComment(@RequestBody Map<String,Object> map){
        Map<String, Object> result = new HashMap<>(4);
        try{
            result = blogCommentsService.commentBlog(map);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
