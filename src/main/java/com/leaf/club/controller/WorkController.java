package com.leaf.club.controller;


import com.leaf.club.model.Work;
import com.leaf.club.service.IWorksService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;



@Controller
@RequestMapping("work")
public class WorkController {

    @Autowired
    private IWorksService worksService;
    private static Logger log = LoggerFactory.getLogger(BlogController.class);

    @RequestMapping("search/{id}")
    @ResponseBody
    public Work getWorkById(@PathVariable("id") int id){
        Work work = null;
        try{
            work = worksService.getWorksById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return work;
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> saveWork(@RequestBody Map<String,Object> map){
        Work work = new Work();
        if(map.get("id") != null){
            work.setId((Integer)map.get("id"));
        }
        if(map.get("userId") != null){
            work.setWorkAuthorId((Integer)map.get("userId"));
        }
        if(map.get("htmlCode") != null) {
            work.setWorkUrl((String) map.get("htmlCode"));
        }
        if(map.get("status") != null) {
            work.setWorkStatus((Integer) map.get("status"));
        }
        if(map.get("tag") != null) {
            work.setWorkTag((String) map.get("tag"));
        }
        if(map.get("typeId") != null) {
            work.setWorkType((Integer) map.get("typeId"));
        }
        if(map.get("title") != null) {
            work.setWorkTitle((String) map.get("title"));
        }
        if((int)map.get("id") == -1) {
            work.setWorkCreateTime(System.currentTimeMillis());
        }else{
            work.setWorkUpdateTime(System.currentTimeMillis());
        }
        log.info("保存文章的前台数据：",work);
        Map<String,Object> result = new HashMap<>(4);
        try {
            result = worksService.saveWork(work);
            return result;
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value = "/praiseWork",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> praiseWork(@RequestBody Map<String,Object> map){
        int id = 0;
        int userId = 0;
        if(map.get("id") != null){
            id = (int)map.get("id");
        }
        if(map.get("userId") != null){
            userId = (int)map.get("userId");
        }
        Map<String,Object> result = new HashMap<>();
        try {
            result = worksService.praiseWork(id,userId);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "/readWork/{id}")
    @ResponseBody
    public Map<String,Object> readWork(@PathVariable("id") int id){
        Map<String,Object> result = new HashMap<>();
        try{
            result = worksService.readWork(id);
        }catch (Exception e){
            e.printStackTrace();
            return result;
        }
        return result;
    }

    @RequestMapping(value = "readAllWork/{count}/{typeId}",method = RequestMethod.GET)
    @ResponseBody
    public  Map<String,Object> readAllWork(@PathVariable("count") int count,@PathVariable("typeId") int typeId){
        Map<String,Object> result = new HashMap<>();
        try{
            result = worksService.readAllByType(count,typeId);
        }catch (Exception e){
            e.printStackTrace();
            return result;
        }
        return result;
    }


    @RequestMapping(value = "readAllWork/{count}",method = RequestMethod.GET)
    @ResponseBody
    public  Map<String,Object> readAll(@PathVariable("count") int count){
        Map<String,Object> result = new HashMap<>();
        try{
            result = worksService.readAll(count);
        }catch (Exception e){
            e.printStackTrace();
            return result;
        }
        return result;
    }
}
