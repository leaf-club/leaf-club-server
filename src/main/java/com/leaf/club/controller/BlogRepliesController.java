package com.leaf.club.controller;

import com.leaf.club.dao.IBlogRepliesDao;
import com.leaf.club.service.IBlogRepliesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@RequestMapping("/blogReply")
public class BlogRepliesController {
    private static Logger log = LoggerFactory.getLogger(BlogRepliesController.class);

    private IBlogRepliesService blogRepliesService;

    @RequestMapping("/reply")
    @ResponseBody
    public Map<String,Object> replyBloge(@RequestBody Map<String,Object> map){
        return null;
    }

}
