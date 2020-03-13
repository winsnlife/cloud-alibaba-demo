package com.wws.cloud.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2020/3/10.
 *
 * @author wws
 */
@RestController
@RequestMapping("/test")
public class RestTemplateTestController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/echo/{str}", method = RequestMethod.GET)
    public String echo(@PathVariable String str) {
        //规范：默认不需要配置context-path
//        return restTemplate.getForObject("http://provider/test/echo/www" + str, String.class);
        return restTemplate.getForObject("http://spring-cloud-alibaba-dubbo-server/test/echo", String.class);
//        return restTemplate.getForEntity("http://provider/test/echo", String.class).getBody();
    }


}
