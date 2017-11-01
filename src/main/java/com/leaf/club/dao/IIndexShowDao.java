package com.leaf.club.dao;

import com.leaf.club.model.IndexShow;

/**
 * @author LL
 */
public interface IIndexShowDao {

    /**
     * 根据id查询index
     * @param id
     * @return
     */
    IndexShow getIndexShowById(int id);
}