package com.leaf.club.dao;

import com.leaf.club.model.IndexShow;

/**
 * @author LL
 */
public interface IIndexShowDao {

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    IndexShow getIndexShowById(int id);
}