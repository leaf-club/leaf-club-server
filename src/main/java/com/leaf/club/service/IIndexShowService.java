package com.leaf.club.service;

import com.leaf.club.model.IndexShow;

/**
 * @author LL
 */
public interface IIndexShowService {

    /**
     * 根据id获取index
     * @param id
     * @return
     */
    IndexShow getIndexShowById(int id);
}