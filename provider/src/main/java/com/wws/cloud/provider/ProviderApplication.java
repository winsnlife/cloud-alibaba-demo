package com.wws.cloud.provider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * Created by Administrator on 2020/2/26.
 *
 * @author wws
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
//@EnableDubbo
public class ProviderApplication {

    @Value("${config.name:空值}")
    private String configName;

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return (String... args) -> {
            System.out.println("configName:"+configName);
        };
    }
}
