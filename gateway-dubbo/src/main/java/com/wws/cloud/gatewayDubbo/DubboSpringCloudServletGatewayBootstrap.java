package com.wws.cloud.gatewayDubbo;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created by Administrator on 2020/3/17.
 *
 * @author wws
 *
 * 服务自省：
 *  后续增加支持，dubbo服务转rest,直接暴露公网访问，待续
 *
 *
 */
@EnableDiscoveryClient
@EnableAutoConfiguration
@EnableFeignClients
@ServletComponentScan(basePackages = "com.wws.cloud.gatewayDubbo.common")
public class DubboSpringCloudServletGatewayBootstrap {

    public static void main(String[] args) {
        new SpringApplicationBuilder(DubboSpringCloudServletGatewayBootstrap.class)
                .properties("spring.profiles.active=dev").run(args);
    }

}