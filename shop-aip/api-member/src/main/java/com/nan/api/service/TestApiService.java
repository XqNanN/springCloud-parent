package com.nan.api.service;

import org.springframework.web.bind.annotation.RequestMapping;
import  java.util.Map;

@RequestMapping("/member")
public interface TestApiService {

    @RequestMapping("/test")
    public Map<String,Object> test(Integer id,String name);


    @RequestMapping("testRedis")
    public String testSetRedis(String key,String value);

}
