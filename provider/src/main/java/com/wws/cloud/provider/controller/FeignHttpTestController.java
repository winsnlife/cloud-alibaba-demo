package com.wws.cloud.provider.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feign")
@Slf4j
class FeignHttpTestController {
    @RequestMapping(value = "/param", method = RequestMethod.GET)
    public String param(String param) {
        log.info("------------haha,from feign client");
        return "feign param provider! param="+param;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(int a,int b) {
        return "feign save provider!a+b="+(a+b);
    }
}