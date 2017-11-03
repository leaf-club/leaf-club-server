package com.leaf.club.controller;

import com.leaf.club.model.User;
import com.leaf.club.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xiechao
 */
@Controller
public class UserController {

    private static Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    @RequestMapping("/user")
    @ResponseBody
    public User getUserById(int id){
        log.info("要查询的用户id={}", id);
        User user = null;
        try {
            user = userService.getUserById(id);
        } catch (Exception e) {
            log.error("查询用户信息异常{}", e.getMessage());
            return user;
        }
        log.info("查询到的用户信息为{}",user.toString());
        return user;
    }
}
