package com.wws.cloud.gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2020/2/28.
 *
 * @author wws
 */
public class TestUserController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UserService userService;

    @GetMapping(value = "/user-rest/{str}")
    public String rest(@PathVariable String str) {
        return restTemplate.getForObject("http://user/test/" + str, String.class);
    }
    @GetMapping(value = "/user-feign/{str}")
    public String feign() {
        return userService.getTest2();
    }
}
