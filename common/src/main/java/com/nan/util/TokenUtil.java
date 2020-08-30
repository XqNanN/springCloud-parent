package com.nan.util;

import java.util.UUID;

public class TokenUtil {
    public  static String getNumberToken(){
        return  "Toke"+ UUID.randomUUID();
    }
}
