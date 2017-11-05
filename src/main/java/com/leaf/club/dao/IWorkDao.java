package com.leaf.club.dao;

import com.leaf.club.model.Work;

/**
 * @author LL
 */
public interface IWorkDao {

    /**
     * 根据id查询作品
     * @param id
     * @return
     */
    Work getWorkById(int id);
}