package com.leaf.club.service;

import com.leaf.club.model.Work;

import java.util.Map;

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

    Map<String,Object> saveWork(Work work);

    Map<String,Object> praiseWork(int id,int userId);

    Map<String,Object> readWorkCount(int id);

    Map<String,Object> readWork(int id);

    Map<String,Object> readAll(int count);

    Map<String,Object> readAllByType(int count,int typeId);
}