package com.demo.login.controller;

import com.alibaba.fastjson.JSON;
import com.demo.login.bean.User;
import com.demo.login.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class LoginController {

    @Autowired
    UserDao userdao;

    @RequestMapping("/login")
    public String Login(User user){
        HashMap<String,Object> resultReturn = new HashMap<>();
        if(user.getUsername() == "" || user.getPassword() == ""){
            resultReturn.put("status","400");
            resultReturn.put("message","Username or password required!");
        }else{
            User queryUser = userdao.getUserInfo(user.getUsername(),user.getPassword());
            if(queryUser == null){
                resultReturn.put("status","401");
                resultReturn.put("message","User's username or password is wrong or user is not exist!");
            }else{
                if(queryUser.getStatus().equals("1")){
                    resultReturn.put("status","200");
                    resultReturn.put("message","success");
                }else{
                    resultReturn.put("status","402");
                    resultReturn.put("message","User is block!");
                }

            }
        }

        return JSON.toJSONString(resultReturn);

    }


}
