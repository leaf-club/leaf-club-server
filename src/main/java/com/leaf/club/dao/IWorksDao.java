package com.leaf.club.dao;

import com.leaf.club.model.Works;

/**
 * @author LL
 */
public interface IWorksDao {

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    Works getWorksById(int id);
}