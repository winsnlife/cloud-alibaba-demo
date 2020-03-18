package com.wws.cloud.consumer.controller;

import com.wws.cloud.consumer.client.HttpFeignRestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2020/3/11.
 *
 * @author wws
 */
@Slf4j
@RestController
@RequestMapping("/httpFeign")
public class HttpFeignTestController {

    @Autowired
    HttpFeignRestService httpFeignRestService;

    @GetMapping("/param")
    public String param(String p){
        return httpFeignRestService.param(p);
    }

    @PostMapping("/save")
    public String save(){
        return httpFeignRestService.save(2,3);
    }

    @GetMapping("/sentinel/hello")
    String hello(){
        return httpFeignRestService.hello();
    }
}
