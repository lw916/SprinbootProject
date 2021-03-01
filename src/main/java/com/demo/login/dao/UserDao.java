package com.demo.login.dao;

import com.demo.login.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    User getUserInfo(@Param("username") String username,@Param("password") String password);
    List<User> queryAllUser(@Param("queryName") String queryName);
    String getUserRole(@Param("username") String username);
}
