package com.nan.api.serviceImpl;

import com.nan.api.service.TestApiService;
import com.nan.common.BaseRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestApiServiceImpl implements TestApiService {

    @Autowired
   private BaseRedisService redisService;

    @Override
    public Map<String, Object> test(Integer id, String name) {

       Map<String,Object> map= new HashMap<String, Object>();
       map.put("errorCode","200");
       map.put("mag","success");
       map.put("data",new String[]{"1","2",id+name});
        return map;
    }

    @Override
    public String testSetRedis(String key, String  value) {
        redisService.setString(key,value,null);
        return  "redis 设置成功";

    }
}
