package com.leaf.club.service;

import com.leaf.club.model.Work;

/**
 * @author LL
 */
public interface IWorksService {

    /**
     * 根据id获取作品
     * @param id
     * @return
     */
    Work getWorksById(int id);
}