package com.nan.message.mq;

import com.alibaba.fastjson.JSONObject;
import com.nan.message.email.MessageAdapterInfo;
import com.nan.message.email.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * 消费者接口，用于监听队列：messages_queue
 */
@Component
@Slf4j
public class Consumer {
   private MessageAdapterInfo messageAdapterInfo;

   @Autowired
   private EmailService emailService;

   @JmsListener(destination="messages_queue")
   public  void distribute (String json){
       log.info("消息平台（消费者）接收到消息：{}",json);
       if (StringUtils.isEmpty(json)){
           return;
       }
       JSONObject rootJson=new JSONObject().parseObject(json);
       JSONObject header= rootJson.getJSONObject("header");
       String type=header.getString("interfaceType");
       if(StringUtils.isEmpty(type)){
           return;
       }
       if("email".equals(type)){
           messageAdapterInfo=emailService;
       }
       if(messageAdapterInfo==null){
           return;
       }

       JSONObject contentJson = rootJson.getJSONObject("content");
        messageAdapterInfo.sendMessage(contentJson);




   }

}
