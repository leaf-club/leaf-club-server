package com.leaf.club.dao;

import com.leaf.club.model.WorkReplies;

/**
 * @author LL
 */
public interface IWorkRepliesDao {

    /**
     * 根据id查询作品回复
     * @param id
     * @return
     */
    WorkReplies getWorkRepliesById(int id);
}