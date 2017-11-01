package com.leaf.club.controller;

import com.leaf.club.model.User;
import com.leaf.club.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xiechao
 */
@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/user")
    @ResponseBody
    public User getUserById(int id){
        return null;
    }
}
