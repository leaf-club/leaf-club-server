package com.leaf.club.service.impl;

import com.leaf.club.dao.IBlogDao;
import com.leaf.club.model.Blog;
import com.leaf.club.service.IBlogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author xuzhiliang
 */

@Service("blogService")
public class BlogServiceImpl implements IBlogService {

//    private static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    /**
     *
     * @param id
     * @return
     */
    @Autowired
    private IBlogDao blogDao;

    @Override
    public Blog getBlogById(int id) {
        Blog blog = null;
        blog = blogDao.getBlogById(id);
        return blog;
    }

    /**
     * 存储文章
     * @param blog
     * @return id
     */
    @Override
    public int saveBlog(Blog blog){
        blogDao.saveBlog(blog);
        int id =  blog.getId();
        return id;
    }

    @Override
    public Boolean praiseBlog(int id){
        int praiseResult = blogDao.praiseBlog(id);
        if(praiseResult > 0){
            return true;
        }
        return false;
    }

    @Override
    public Boolean readBlogCount(int id){
        int readCountResult = blogDao.readBlogCount(id);
        if(readCountResult > 0){
            return true;
        }
        return false;
    }

    @Override
    public String getBlogSourceById(int id){
        String source = blogDao.getBlogSourceById(id);
        return source;
    }
}
