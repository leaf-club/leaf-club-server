package com.leaf.club.dao;

import com.leaf.club.model.Work;

import java.util.List;
import java.util.Map;

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

    Work getWork(int id);

    int saveWork(Work work);

    int reSaveWork(Work work);

    int readWorkCount(int id);

    List<Map<String,Object>> readAll(int count);

    List<Map<String,Object>> readAllByType(Map<String,Object> selectByType);

    int praiseWork(int id,int userId);

    Map<String,Object> readWork(int id);
}