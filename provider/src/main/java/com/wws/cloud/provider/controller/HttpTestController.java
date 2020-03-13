package com.wws.cloud.provider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
class HttpTestController {
    @RequestMapping(value = "/echo", method = RequestMethod.GET)
    public String echo() {
        return "Hello,i'm provider!";
    }
}