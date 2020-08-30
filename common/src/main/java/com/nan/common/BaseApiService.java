package com.nan.common;

public class BaseApiService {
    public BaseResponse setResult(Integer code,String msg,Object obj){

        return  new BaseResponse(code,msg,obj);
    }
}
