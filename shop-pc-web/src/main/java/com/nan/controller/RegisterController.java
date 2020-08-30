package com.nan.controller;

import com.nan.entity.UserEntity;
import com.nan.fegin.MemberServiceFegin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RegisterController {
    public static final  String REGISTER="register";

    @Autowired
    private MemberServiceFegin  memberServiceFegin;

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public  String  register(UserEntity userEntity, HttpServletRequest request){

        //验证参数
        //调用注册接口
       boolean result= memberServiceFegin.registerUser(userEntity);
        //失败跳转到失败页面
        if(!result){
            request.setAttribute("error","注册失败");
            return  "ERROR";
        }
        //成功跳转到成功页面


        return  REGISTER;
    }

}
