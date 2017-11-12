package com.leaf.club.service.impl;

import com.leaf.club.dao.IBlogPraiseDao;
import com.leaf.club.service.IBlogPraiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("BlogPraiseService")
public class BlogPraiseServiceImpl implements IBlogPraiseService{
    @Autowired
    private IBlogPraiseDao praiseBlogDao;

    @Override
    public Map<String,Object> praiseBlog(Map<String,Object> map){
        int praiseResult = 0;
        Map<String,Object> temp = new HashMap<>();
        Map<String,Object> result = new HashMap<>();
        if(map.get("id") == null ||  map.get("userId") == null){
            temp.put("code",2);
            temp.put("msg","消息为空");
            result.put("result",temp);
            return result;
        }
        try {
            Object tag = praiseBlogDao.praiseBlogSelect(map);
            if(tag == null ){
                praiseResult = praiseBlogDao.praiseBlogInsert(map);
                praiseBlogDao.praiseBlogUpdate((int)map.get("id"));
                if(praiseResult == 1){
                    temp.put("code",1);
                    temp.put("msg","点赞成功");
                    result.put("result",temp);
                    return result;
                }
            }else{
                praiseResult = praiseBlogDao.praiseBlogDelete(map);
                praiseBlogDao.praiseBlogUpdateMinus((int)map.get("id"));
                if(praiseResult == 1){
                    temp.put("code",1);
                    temp.put("msg","取消点赞成功");
                    result.put("result",temp);
                    return result;
                }
            }
            praiseResult = praiseBlogDao.praiseBlogInsert(map);
            int praiseUpdate = praiseBlogDao.praiseBlogUpdate((int)map.get("id"));
        }catch (Exception e) {
            e.printStackTrace();
            temp.put("code",4);
            temp.put("msg","数据库异常");
            result.put("result",temp);
            return result;
        }
        if(praiseResult == 0){
            temp.put("code",3);
            temp.put("msg","点赞的博文不存在");
            result.put("result",temp);
            return result;
        }
        temp.put("code",1);
        temp.put("msg","点赞成功");
        result.put("result",temp);
        return result;
    }
}
