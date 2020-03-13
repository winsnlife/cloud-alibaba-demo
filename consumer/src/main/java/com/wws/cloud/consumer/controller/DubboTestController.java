package com.wws.cloud.consumer.controller;

import com.wws.cloud.facade.service.DubboEchoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2020/3/11.
 *
 * @author wws
 */
@RestController
@RequestMapping("/dubbo")
public class DubboTestController {

    @Reference
    DubboEchoService echoService;

    @GetMapping("/echo")
    public String echo(String message) {
        return echoService.echo(message);
    }

}
