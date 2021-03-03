package com.demo.login.controller;

import com.alibaba.fastjson.JSON;
import com.demo.login.bean.User;
import com.demo.login.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
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
            resultReturn.put("flag","400");
            resultReturn.put("messages","账户或密码未输入！");
        }else{
            User queryUser = userdao.getUserInfo(user.getUsername(),user.getPassword());
            if(queryUser == null){
                resultReturn.put("flag","401");
                resultReturn.put("messages","账户名或密码错误/账户不存在");
            }else{
                if(queryUser.getStatus().equals("1")){
                    resultReturn.put("flag","200");
                    resultReturn.put("messages","登陆成功");
                }else{
                    resultReturn.put("flag","402");
                    resultReturn.put("messages","账户被禁用");
                }

            }
        }

        return JSON.toJSONString(resultReturn);

    }


}
