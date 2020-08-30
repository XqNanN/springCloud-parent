package com.nan.common;
/*
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import  java.util.Arrays;
import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@Slf4j
public class LogAspectServcie {
    private JSONObject jsonObject=new JSONObject();


    //                   开放类型\返回值\包名\类名\方法名\（..）
    @Pointcut("execution(public * com.nan.api.serviceImpl.TestApiServiceImpl.test(..))")
    private void controllerAspect(){}

    @Before(value ="controllerAspect()")
    public  void beforMethod(JoinPoint joinPoint){
     ServletRequestAttributes attributes=(ServletRequestAttributes)
             RequestContextHolder.getRequestAttributes();
        HttpServletRequest  request=attributes.getRequest();
        log.info("==================请求内容111111111===================");
          try{
              log.info("请求地址:" + request.getRequestURL().toString());
              log.info("请求方式:" + request.getMethod());
              log.info("请求类方法:" + joinPoint.getSignature());
              log.info("请求类方法参数:" + Arrays.toString(joinPoint.getArgs()));

          }catch (Exception e){
              log.error("###LogAspectServcie.class methodBefore() ### ERROR:", e);

          }

    }
}
*/
