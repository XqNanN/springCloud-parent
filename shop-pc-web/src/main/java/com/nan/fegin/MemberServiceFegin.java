package com.nan.fegin;

import com.nan.api.service.MemberServiceInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient("member")
public interface MemberServiceFegin extends MemberServiceInfo{
}
