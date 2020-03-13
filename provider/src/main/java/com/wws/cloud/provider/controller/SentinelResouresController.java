package com.wws.cloud.provider.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2020/3/10.
 *
 * @author wws
 */
@RestController
@RequestMapping("/sentinel")
public class SentinelResouresController {

    @RequestMapping("/hello")
//    @SentinelResource(value = "resource", blockHandler = "", blockHandlerClass = ExceptionUtil.class)
    public String hello() {
        return "Hello";
    }

    // ExceptionUtil.java
    public static class ExceptionUtil {
        public static void handleException(BlockException ex) {
            System.out.println("Oops: " + ex.getClass().getCanonicalName());
        }
    }
}
