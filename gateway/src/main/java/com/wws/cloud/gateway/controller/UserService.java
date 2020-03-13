package com.wws.cloud.gateway.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Administrator on 2020/2/28.
 *
 * @author wws
 */
@FeignClient(name = "user")
public interface UserService {

    @GetMapping(value = "/test2")
    String getTest2();
}
