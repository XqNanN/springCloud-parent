package com.nan.message.email;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Slf4j
@Service
public class EmailService implements MessageAdapterInfo {

    @Value("${msg.subject}")
    private String subject;

    @Value("${msg.text}")
    private String  text;

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendMessage(JSONObject message) {

        String emailMessage = message.getString("email");

           if(StringUtils.isEmpty(emailMessage)){
               return;
           }

           log.info("消息平台发送邮件：{}",emailMessage);

        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();

        simpleMailMessage.setFrom(emailMessage);//来自账号
        simpleMailMessage.setTo(emailMessage); //发送账号
        simpleMailMessage.setSubject(subject);  //标题
        simpleMailMessage.setText(text.replace("{}",emailMessage));
        try{
            javaMailSender.send(simpleMailMessage);

        }catch (Exception e){
            log.info(e.toString());
            return;
        }


        log.info("发送消息完成！！！");



    }
}
