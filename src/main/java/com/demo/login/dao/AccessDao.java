package com.demo.login.dao;

import com.demo.login.bean.QueryAccess;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccessDao {
    List<QueryAccess> queryAccess(@Param("queryUser") String queryUser);

}
