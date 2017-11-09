package com.leaf.club.service.impl;

import com.leaf.club.dao.IBlogCommentsDao;
import com.leaf.club.model.BlogComments;
import com.leaf.club.service.IBlogCommentsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("blogCommentsService")
public class BlogCommentsServiceImpl implements IBlogCommentsService {

//    private static Logger log = LoggerFactory.getLogger(BlogCommentsServiceImpl.class);

    @Autowired
    private IBlogCommentsDao blogCommentsDao;
    @Override
    public BlogComments getBlogCommentsById(int id){
        BlogComments blogComments;
        blogComments = blogCommentsDao.getBlogCommentsById(id);
        return blogComments;
    }


    @Override
    public Map<String,Object> commentBlog(Map<String, Object> map){
        Map<String,Object> result = new HashMap<>(4);
        Map<String,Object> temp = new HashMap<>(4);
        if(!map.containsKey("commentBlogId") || map.get("commentBlogId").equals(0)){
            temp.put("code",3);
            temp.put("msg","请选择评论的对象");
            result.put("result",temp);
            return result;
        }else if(!map.containsKey("commentUserId") || map.get("commentUserId").equals(0)){
            temp.put("code",6);
            temp.put("msg","请先登录");
            result.put("result",temp);
            return result;
        }else if(!map.containsKey("commentContent") || map.get("commentContent").equals("")){
            temp.put("code",3);
            temp.put("msg","请输入评论的内容");
            result.put("result",temp);
            return result;
        }
        try {
            int id = blogCommentsDao.commentBlog(map);
            temp.put("code",1);
            temp.put("code","插入成功");
            result.put("result",temp);
            result.put("id",id);
        }catch (Exception e){
            e.printStackTrace();
            temp.put("code",4);
            temp.put("msg","评论插入数据库异常");
            return result;
        }
        return result;
    }

}
