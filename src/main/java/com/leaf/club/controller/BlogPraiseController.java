package com.leaf.club.controller;

import com.leaf.club.dao.IBlogPraiseDao;
import com.leaf.club.service.IBlogPraiseService;
import com.leaf.club.service.IUserFavoritesBlogsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/praiseBlog")
public class BlogPraiseController {

    private static Logger log = LoggerFactory.getLogger(BlogPraiseController.class);
    @Autowired()
//    private IUserFavoritesBlogsService userFavoritesBlogsService;
    private IBlogPraiseService blogPraiseService;
    @RequestMapping(value = "praise",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> favoritesBlog(@RequestBody Map<String,Object> map){
        Map<String,Object> temp = new HashMap<>();
        Map<String,Object> result = new HashMap<>();
        try {
            result = blogPraiseService.praiseBlog(map);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return result;
    }
}
