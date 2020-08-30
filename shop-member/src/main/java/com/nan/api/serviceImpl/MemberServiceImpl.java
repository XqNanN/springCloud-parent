package com.nan.api.serviceImpl;

import com.alibaba.fastjson.JSONObject;
import com.mysql.jdbc.StringUtils;
import com.nan.api.service.MemberServiceInfo;
import com.nan.common.BaseApiService;
import com.nan.common.BaseRedisService;
import com.nan.common.BaseResponse;
import com.nan.dao.MemberDao;
import com.nan.entity.UserEntity;
import com.nan.mq.RegisterProducer;
import com.nan.util.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MemberServiceImpl extends BaseApiService implements MemberServiceInfo  {

    @Autowired
    private MemberDao memberDao;

    @Autowired
    private BaseRedisService baseRedisService;

    @Autowired
    private RegisterProducer registerProducer;

    @Value("${messages.queue}")
    private String MESSAGESQUEUE;

    @Override
    public UserEntity getUserByID(Long id) {
        return memberDao.findUserByID(id);
    }

    @Override
    public boolean registerUser( @RequestBody UserEntity user) {

       boolean result= memberDao.insertUser(user);
       if(!result){
           return  false;
       }
        String email= user.getEmail();
        String jsonE=emailJson(email);
        log.info("将服务推送到消息平台：##########{}",jsonE);
        sendMsg(jsonE);
        return  true;
    }

    @Override
    public boolean login(UserEntity user) {

        // 验证参数，数据库查询账号密码，生成token，存放redis，返回token
        String userName= user.getUsername();
        if(StringUtils.isNullOrEmpty(userName)){
            return false ;
        }

        String password=user.getPassword();
        if(StringUtils.isNullOrEmpty(password)){
            return  false;
        }

        String tokenNumber= TokenUtil.getNumberToken();
       Integer userID= user.getId();
         baseRedisService.setString(tokenNumber,userID,60L);
         return  true;
    }

    @Override
    public BaseResponse getUserByToken(String token) {
        if(StringUtils.isNullOrEmpty(token)){
           return setResult(500,"token不能为空",60L);
        }

       int userID=Integer.parseInt(baseRedisService.getString(token));
        UserEntity user= memberDao.findUserByID(userID);
        return  setResult(200,"登陆成功",user);
    }

    private String emailJson(String email) {
         JSONObject rootJson = new JSONObject();
        JSONObject header = new JSONObject();
        header.put("interfaceType","email");
        JSONObject target = new JSONObject();
         target.put("email", email);
        rootJson.put("header", header);
        rootJson.put("content", target);
        return rootJson.toJSONString();
    }

    private void sendMsg(String json) {
        ActiveMQQueue activeMQQueue = new ActiveMQQueue(MESSAGESQUEUE);
        registerProducer.sendMsg(activeMQQueue,json);

    }
}
