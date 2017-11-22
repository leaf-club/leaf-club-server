package com.leaf.club.service.impl;


import com.leaf.club.dao.IWorkDao;
import com.leaf.club.model.Work;
import com.leaf.club.service.IWorksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("workService")
public class WorksServiceImpl implements IWorksService {


    @Autowired
    private IWorkDao workDao;
    @Override
    public Work getWorksById(int id) {
        Work work = null;
        try{
            work = workDao.getWorkById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return work;
    }

    @Override
    public Map<String, Object> saveWork(Work work) {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> temp = new HashMap<>();
        if (work.getWorkUrl() == null) {
            temp.put("code", 2);
            temp.put("msg", "作品的url地址的为空");
            map.put("result", temp);
            return map;
        } else if (work.getWorkTitle() == null) {
            temp.put("code", 2);
            temp.put("msg", "作品的标题的为空");
            map.put("result", temp);

            return map;
        } else if (work.getWorkAuthorId() == 0) {
            temp.put("code", 6);
            temp.put("msg", "请先登录");
            map.put("result", temp);
            return map;
        } else if (work.getWorkType() == 0) {
            temp.put("code", 2);
            temp.put("msg", "请选择作品的分类");
            map.put("result", temp);
            return map;
        }
        switch (work.getWorkType()) {
            case 1:
                work.setWorkTypeName("前端");
                break;
            case 2:
                work.setWorkTypeName("后台");
                break;
            default:
                work.setWorkTypeName("ios");
                break;
        }
        int saveWork;
        if (work.getId() == -1) {
            saveWork = workDao.saveWork(work);
        } else {
            saveWork = workDao.reSaveWork(work);
        }

        if (saveWork == 0) {
            temp.put("code", 4);
            temp.put("msg", "文章插入异常");
            map.put("result", temp);
            return map;
        }
        temp.put("code", 1);
        temp.put("msg", "success");
        map.put("result", temp);
        int id = work.getId();
        Map<String,Object> returnId = new HashMap<>();
        returnId.put("id",id);
        map.put("data", returnId);
        return map;
    }

    @Override
    public Map<String, Object> praiseWork(int id, int userId) {
        int praiseResult = 0;
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> temp = new HashMap<>();
        if (userId == 0 || id == 0) {
            temp.put("code", 2);
            temp.put("msg", "消息为空");
            map.put("result", temp);
            return map;
        }
        try {
            praiseResult = workDao.praiseWork(id, userId);
        } catch (Exception e) {
            e.printStackTrace();
            temp.put("code", 4);
            temp.put("msg", "数据库异常");
            map.put("result", temp);
            return map;
        }
        if (praiseResult == 0) {
            temp.put("code", 3);
            temp.put("msg", "点赞的作品不存在");
            map.put("result", temp);
            return map;
        }
        temp.put("code", 1);
        temp.put("msg", "点赞成功");
        map.put("result", temp);
        return map;
    }

    @Override
    public Map<String, Object> readWorkCount(int id) {
        Map<String, Object> temp = new HashMap<>();
        Map<String, Object> map = new HashMap<>();
        int readCountResult = 0;
        try {
            readCountResult = workDao.readWorkCount(id);
        } catch (Exception e) {
            e.printStackTrace();
            temp.put("code", 4);
            temp.put("msg", "数据库异常");
            map.put("result", temp);
            return map;
        }
        if (readCountResult == 0) {
            temp.put("code", 3);
            temp.put("msg", "阅读的作品不存在");
            map.put("result", temp);
        }
        temp.put("code", 1);
        temp.put("msg", "成功");
        map.put("result", temp);
        return map;
    }

    @Override
    public Map<String, Object> readWork(int id) {
        Map<String, Object> map = null;
        Map<String, Object> result = new HashMap<>();
        Map<String, Object> temp = new HashMap<>();
        try {
            map = workDao.readWork(id);
            result.put("data", map);
            temp.put("code", 200);
            temp.put("msg", "success");
            result.put("result", temp);
        } catch (Exception e) {
            e.printStackTrace();
            temp.put("code", 500);
            temp.put("msg", "fail");
            result.put("result", temp);
            return result;
        }
        return result;
    }

    @Override
    public Map<String, Object> readAll(int count) {
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> result = new HashMap<>();
        Map<String, Object> temp = new HashMap<>();
        try {
            list =workDao.readAll(count);
            temp.put("code", 200);
            temp.put("msg", "success");
            result.put("result", temp);
            result.put("data", list);
            return result;
        } catch (Exception e) {
            temp.put("code", 500);
            temp.put("msg", "fail");
            result.put("result", temp);
            e.printStackTrace();
            return result;
        }
    }

    @Override
    public Map<String, Object> readAllByType(int count, int typeId) {
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> result = new HashMap<>();
        Map<String, Object> temp = new HashMap<>();
        try {
            Map<String,Object> selectByType = new HashMap<>();
            selectByType.put("count",count);
            selectByType.put("typeId",typeId);
            list = workDao.readAllByType(selectByType);
            temp.put("code", 200);
            temp.put("msg", "success");
            result.put("result", temp);
            result.put("data", list);
            return result;
        } catch (Exception e) {
            temp.put("code", 500);
            temp.put("msg", "fail");
            result.put("result", temp);
            e.printStackTrace();
            return result;
        }
    }
}
