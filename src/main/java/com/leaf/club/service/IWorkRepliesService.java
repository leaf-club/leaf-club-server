package com.leaf.club.service;

import com.leaf.club.model.WorkReplies;

/**
 * @author LL
 */
public interface IWorkRepliesService {

    /**
     * 根据id获取作品回复
     * @param id
     * @return
     */
    WorkReplies getWorkRepliesById(int id);
}