package com.leaf.club.service;

import com.leaf.club.model.Works;

/**
 * @author LL
 */
public interface IWorksService {

    /**
     * 根据id获取作品
     * @param id
     * @return
     */
    Works getWorksById(int id);
}