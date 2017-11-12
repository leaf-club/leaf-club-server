package com.leaf.club.service.impl;

import com.leaf.club.dao.IUserFavoritesBlogsDao;
import com.leaf.club.model.UserFavoritesBlogs;
import com.leaf.club.service.IUserFavoritesBlogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service("favoritesBlogServivce")
public class UserFavoritesBlogsServiceImpl implements IUserFavoritesBlogsService{


    @Autowired
    private  IUserFavoritesBlogsDao userFavoritesBlogsDao;

    @Override
    public Map<String,Object> favoritesBlog(Map<String,Object> map){
        int favoritesResult = 0;
        Map<String,Object> temp = new HashMap<>();
        Map<String,Object> result = new HashMap<>();
        if(map.get("id") == null ||  map.get("userId") == null){
            temp.put("code",2);
            temp.put("msg","消息为空");
            result.put("result",temp);
            return result;
        }
        try {
            Object tag = userFavoritesBlogsDao.favoritesBlogSelect(map);
            if(tag == null ){
                favoritesResult = userFavoritesBlogsDao.favoritesBlogInsert(map);
                userFavoritesBlogsDao.favoritesBlogUpdate((int)map.get("id"));
                if(favoritesResult == 1){
                    temp.put("code",1);
                    temp.put("msg","收藏成功");
                    result.put("result",temp);
                    return result;
                }
            }else{
                favoritesResult = userFavoritesBlogsDao.favoritesBlogDelete(map);
                userFavoritesBlogsDao.favoritesBlogUpdateMinus((int)map.get("id"));
                if(favoritesResult == 1){
                    temp.put("code",1);
                    temp.put("msg","取消收藏成功");
                    result.put("result",temp);
                    return result;
                }
            }
            favoritesResult = userFavoritesBlogsDao.favoritesBlogInsert(map);
            int favoritesUpdate = userFavoritesBlogsDao.favoritesBlogUpdate((int)map.get("id"));
        }catch (Exception e) {
            e.printStackTrace();
            temp.put("code",4);
            temp.put("msg","数据库异常");
            result.put("result",temp);
            return result;
        }
        if(favoritesResult == 0){
            temp.put("code",3);
            temp.put("msg","收藏的博文不存在");
            result.put("result",temp);
            return result;
        }
        temp.put("code",1);
        temp.put("msg","收藏成功");
        result.put("result",temp);
        return result;
    }

    @Override
    public UserFavoritesBlogs getUserFavoritesBlogsById(int id) {
        return null;
    }
}
