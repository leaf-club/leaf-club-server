package com.leaf.club.dao;

import com.leaf.club.model.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author xiechao
 */
public interface IUserDao {

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    User getUserById(@Param("id")int id);
}
