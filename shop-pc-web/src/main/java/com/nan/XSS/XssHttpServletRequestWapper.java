package com.nan.XSS;


import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class XssHttpServletRequestWapper extends HttpServletRequestWrapper {

    private  HttpServletRequest request;
    public  XssHttpServletRequestWapper(HttpServletRequest request){
        super(request);
        this.request=request;
    }

    @Override
    public  String getParameter(String name){
        String preValue=super.getParameter(name);
        if(StringUtils.isNotBlank(preValue)){
            preValue= StringEscapeUtils.escapeHtml(preValue);
        }
        return  preValue;
    }



}
