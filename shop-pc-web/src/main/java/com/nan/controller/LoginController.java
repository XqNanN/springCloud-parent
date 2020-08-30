package com.nan.controller;

import com.nan.entity.UserEntity;
import com.nan.fegin.MemberServiceFegin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    private final String INDEX = "login";

    @Autowired
    private MemberServiceFegin memberServiceFegin;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {

        return INDEX;

    }

    @RequestMapping(value = "/login",method =RequestMethod.POST)
    public String login(UserEntity userEntity){
        //验证参数
        //调用接口，获取token
        memberServiceFegin.login(userEntity);

        return  INDEX;
    }

}
