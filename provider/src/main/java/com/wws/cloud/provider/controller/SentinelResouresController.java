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
    @SentinelResource(value = "hello", blockHandler = "handleException2", blockHandlerClass = ExceptionUtil.class)
    public String hello() {
        return "Hello";
    }

    // ExceptionUtil.java
    public static class ExceptionUtil {
        /*返回值，参数类型个数，要一致，最后一个参数可以增加是Throwable类型*/
        public static void handleException(BlockException ex) {
            System.out.println("Oops: " + ex.getClass().getCanonicalName());
        }
        public static String handleException2(BlockException ex) {
            return  "Oops: " + ex.getClass().getCanonicalName();
        }
    }

    // 对应的 `handleException` 函数需要位于 `ExceptionUtil` 类中，并且必须为 static 函数.
    @RequestMapping("/test")
    @SentinelResource(value = "test", blockHandler = "handleException", blockHandlerClass = {ExceptionUtil.class})
    public void test() {
        System.out.println("Test");
    }

    // 原函数
    @RequestMapping("/hello2")
    @SentinelResource(value = "hello", blockHandler = "exceptionHandler", fallback = "helloFallback")
    public String hello2(long s) {
        return String.format("Hello2 at %d", s);
    }

    // Fallback 函数，函数签名与原函数一致或加一个 Throwable 类型的参数.
    public String helloFallback(long s) {
        return String.format("Halooooo2 %d", s);
    }

    // Block 异常处理函数，参数最后多一个 BlockException，其余与原函数一致.
    public String exceptionHandler(long s, BlockException ex) {
        // Do some log here.
        ex.printStackTrace();
        return "Oops, error occurred at " + s;
    }
}
