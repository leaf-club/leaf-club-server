package com.leaf.club.service;

import com.leaf.club.model.WorkComments;

/**
 * @author LL
 */
public interface IWorkCommentsService {

    /**
     * 根据id获取作品评论
     * @param id
     * @return
     */
    WorkComments getWorkCommentsById(int id);
}