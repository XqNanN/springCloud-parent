package com.nan.message.email;

import com.alibaba.fastjson.JSONObject;

/**
 * 统一发送消息的接口
 */
public interface MessageAdapterInfo {

    public void sendMessage(JSONObject message);
}
