package com.wws.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2020/2/26.
 *
 * @author wws
 */
@RefreshScope
@RestController
public class ConfigClientController {

    @Value("${info:空值}")
    private String configInfo;
    @Value("${test.info:空值}")
    private String testInfo;

    @GetMapping("/info")
    public Object getConfigInfo() {
        return configInfo;
    }

    @GetMapping("/test/info")
    public Object getTestConfigInfo() {
        return testInfo;
    }


}
