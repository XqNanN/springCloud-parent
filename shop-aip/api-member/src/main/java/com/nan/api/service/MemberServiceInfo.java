package com.nan.api.service;

import com.nan.common.BaseResponse;
import com.nan.entity.UserEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/memberUser")
public interface MemberServiceInfo {

    @RequestMapping("/getUser")
    public UserEntity getUserByID(Long id);

    @RequestMapping("/registUser")
    public boolean registerUser(@RequestBody UserEntity user);


    @RequestMapping("/login")  //应该是返回String token
    public boolean login(@RequestBody UserEntity user);

    @RequestMapping("/loginByToken")
    public BaseResponse getUserByToken(String token);
}
