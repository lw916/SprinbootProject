package com.demo.login.controller;

import com.alibaba.fastjson.JSON;
import com.demo.login.bean.QueryAccess;
import com.demo.login.bean.QueryUser;
import com.demo.login.bean.User;
import com.demo.login.dao.AccessDao;
import com.demo.login.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class QueryController {

    @Autowired
    UserDao userDao;

    @Autowired
    AccessDao accessDao;

    @RequestMapping("/queryUser")
    public String queryAllUserInfo(User user, QueryUser queryUser){

        HashMap<String,Object> result = new HashMap<>();
        if(userDao.getUserRole(user.getUsername()).equals("admin")){
            List<User> queryList = userDao.queryAllUser(queryUser.getQueryName());
            result.put("status","200");
            result.put("message","Success");
            result.put("value",queryList);
            System.out.println(queryList);
        }else{
            result.put("status","400");
            result.put("message","No permission");
            result.put("value",null);
        }
        return JSON.toJSONString(result);
    }

    @RequestMapping("/access")
    public String queryAccess(String queryUser){
        HashMap<String,Object> result = new HashMap<>();
        List<QueryAccess> resultList = null;
        try{
            resultList = accessDao.queryAccess(queryUser);
        }catch(Exception e){
            System.out.println(e);
        }
        if(resultList != null){
            result.put("status","200");
            result.put("value",resultList);
        }else{
            result.put("status","400");
            result.put("value",null);
        }
        return JSON.toJSONString(result);
    }

}