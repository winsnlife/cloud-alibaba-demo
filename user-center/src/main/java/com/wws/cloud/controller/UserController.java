package com.wws.cloud.controller;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2020/2/27.
 *
 * @author wws
 */
//@RefreshScope
@RestController
public class UserController {

    @GetMapping("/test")
    public Object getTest() {
        return "test-user";
    }
}
