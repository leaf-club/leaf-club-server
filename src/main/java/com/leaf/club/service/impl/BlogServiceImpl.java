package com.leaf.club.service.impl;

import com.leaf.club.dao.IBlogDao;
import com.leaf.club.model.Blog;
import com.leaf.club.service.IBlogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author xuzhiliang
 */

@Service("blogService")
public class BlogServiceImpl implements IBlogService {

//    private static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    /**
     * @param id
     * @return
     */
    @Autowired
    private IBlogDao blogDao;

    @Override
    public Blog getBlogById(int id) {
        Blog blog = null;
        try {
            blog = blogDao.getBlogById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return blog;
    }

    /**
     * 存储文章
     *
     * @param blog
     * @return id
     */
    @Override
    public Map<String, Object> saveBlog(Blog blog) {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> temp = new HashMap<>();
        if (blog.getBlogContent() == null) {
            temp.put("code", 2);
            temp.put("msg", "博文的内容的为空");
            map.put("result", temp);
            return map;
        } else if (blog.getBlogTitle() == null) {
            temp.put("code", 2);
            temp.put("msg", "博文的标题的为空");
            map.put("result", temp);

            return map;
        } else if (blog.getBlogAuthorId() == 0) {
            temp.put("code", 6);
            temp.put("msg", "请先登录");
            map.put("result", temp);
            return map;
        } else if (blog.getBlogType() == 0) {
            temp.put("code", 2);
            temp.put("msg", "请选择文章的分类");
            map.put("result", temp);
            return map;
        }
        switch (blog.getBlogType()) {
            case 1:
                blog.setBlogTypeName("前端");
            case 2:
                blog.setBlogTypeName("后台");
            default:
                blog.setBlogTypeName("ios");
        }
        int saveBlog;
        if (blog.getId() == -1) {
            saveBlog = blogDao.saveBlog(blog);
        } else {
            saveBlog = blogDao.reSaveBlog(blog);
        }

        if (saveBlog == 0) {
            temp.put("code", 4);
            temp.put("msg", "文章插入异常");
            map.put("result", temp);
            return map;
        }
        temp.put("code", 1);
        temp.put("msg", "success");
        map.put("result", temp);
        int id = blog.getId();
        map.put("data", new HashMap<String, Object>().put("id", id));
        return map;
    }

    @Override
    public Map<String, Object> praiseBlog(int id, int userId) {
        int praiseResult = 0;
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> temp = new HashMap<>();
        if (userId == 0 || id == 0) {
            temp.put("code", 2);
            temp.put("msg", "消息为空");
            map.put("result", temp);
            return map;
        }
        try {
            praiseResult = blogDao.praiseBlog(id, userId);
        } catch (Exception e) {
            e.printStackTrace();
            temp.put("code", 4);
            temp.put("msg", "数据库异常");
            map.put("result", temp);
            return map;
        }
        if (praiseResult == 0) {
            temp.put("code", 3);
            temp.put("msg", "点赞的博文不存在");
            map.put("result", temp);
            return map;
        }
        temp.put("code", 1);
        temp.put("msg", "点赞成功");
        map.put("result", temp);
        return map;
    }

    @Override
    public Map<String, Object> readBlogCount(int id) {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> temp = new HashMap<>();
        int readCountResult = 0;
        try {
            readCountResult = blogDao.readBlogCount(id);
        } catch (Exception e) {
            e.printStackTrace();
            temp.put("code", 4);
            temp.put("msg", "数据库修改异常");
            map.put("result", temp);
            return map;
        }
        if (readCountResult == 0) {
            temp.put("code", 3);
            temp.put("msg", "阅读的博文不存在");
            map.put("result", temp);
        }
        temp.put("code", 1);
        temp.put("msg", "成功");
        map.put("result", temp);
        return map;
    }

    @Override
    public Map<String, Object> readAllBlogByPage(Map<String, Object> map) {
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> result = new HashMap<>();
        Map<String, Object> temp = new HashMap<>();
        if (map.get("currPage").equals(0)) {
            temp.put("code", 500);
            temp.put("msg", "fail");
            result.put("result", temp);
        } else {
            try {
                list = blogDao.readAllBlogByPage(map);
                temp.put("code", 200);
                temp.put("msg", "success");
                result.put("result", temp);
                result.put("data", list);
                return result;
            } catch (Exception e) {
                temp.put("code", 500);
                temp.put("msg", "fail");
                result.put("result", temp);
                return result;
            }
        }
        return result;
    }

    @Override
    public Map<String, Object> readTypeBlogByPage(Map<String, Object> map) {
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> result = new HashMap<>();
        Map<String, Object> temp = new HashMap<>();
        if (map.get("currPage").equals(0) || map.get("type").equals(0)) {
            temp.put("code", 500);
            temp.put("msg", "fail");
            result.put("result", temp);
        } else {
            try {
                list = blogDao.readAllBlogByPage(map);
                temp.put("code", 200);
                temp.put("msg", "success");
                result.put("result", temp);
                result.put("data", list);
                return result;
            } catch (Exception e) {
                temp.put("code", 500);
                temp.put("msg", "fail");
                result.put("result", temp);
                e.printStackTrace();
                return result;
            }
        }
        return result;
    }

    @Override
    public Map<String, Object> readBlog(int id) {
        Map<String, Object> map = null;
        Map<String, Object> result = new HashMap<>();
        Map<String, Object> temp = new HashMap<>();
        try {
            map = blogDao.readBlog(id);
            result.put("data", map);
            temp.put("code", 200);
            temp.put("msg", "success");
            result.put("result", temp);
        } catch (Exception e) {
            e.printStackTrace();
            temp.put("code", 500);
            temp.put("msg", "fail");
            result.put("result", temp);
            return result;
        }
        return result;
    }
}
