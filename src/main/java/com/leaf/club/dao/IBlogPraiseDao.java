package com.leaf.club.dao;

import java.util.Map;

public interface IBlogPraiseDao {


    /**
     * praise_blog插入数据
     * @param map
     * @return
     */
    int praiseBlogInsert(Map<String,Object> map);

    /**
     * 更新blogs的praise_count
     * @param id
     * @return
     */
    int  praiseBlogUpdate(int id);

    /**
     * 检测用户是否已经收藏
     * @param map
     * @return
     */
    Integer praiseBlogSelect(Map<String,Object> map);

    /**
     * 取消收藏
     * @param map
     * @return
     */
    int praiseBlogDelete(Map<String,Object> map);

    /**
     * blog的praise_count--
     * @param id
     * @return
     */
    int praiseBlogUpdateMinus(int id);
}
