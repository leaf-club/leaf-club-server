package com.leaf.club.controller;


import com.leaf.club.model.IndexShow;
import com.leaf.club.service.IIndexShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xiechao
 */
@Controller
public class IndexShowController {

    @Autowired
    private IIndexShowService indexShowService;

    @RequestMapping("/indexShow")
    @ResponseBody
    public IndexShow getIndexShowById(int id){
        return indexShowService.getIndexShowById(id);
    }
}
