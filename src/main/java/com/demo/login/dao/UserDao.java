package com.demo.login.dao;

import com.demo.login.bean.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    public User getUserInfo(@Param("username") String username,@Param("password") String password);
}
