package com.leaf.club.dao;

import com.leaf.club.model.WorkComments;

/**
 * @author LL
 */
public interface IWorkCommentsDao {

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    WorkComments getWorkCommentsById(int id);
}