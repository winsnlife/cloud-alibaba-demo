package com.wws.cloud.provider;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Collections;

/**
 * Created by Administrator on 2020/2/26.
 *
 * @author wws
 */
@EnableDiscoveryClient
@SpringBootApplication
//@EnableFeignClients
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
//            initFlowRule();
        };
    }

    private static void initFlowRule() {
        FlowRule flowRule = new FlowRule();
        //针对具体的方法限流
        flowRule.setResource("com.wws.cloud.facade.service.DubboEchoService(java.lang.String) ");
        flowRule.setCount(2);//限流阈值 qps=10
        flowRule.setGrade(RuleConstant.FLOW_GRADE_QPS);//限流阈值类型（QPS 或并发线程数）
        flowRule.setLimitApp("default");//流控针对的调用来源，若为 default 则不区分调用来源
        // 流量控制手段（直接拒绝、Warm Up、匀速排队）
        flowRule.setControlBehavior(RuleConstant.CONTROL_BEHAVIOR_DEFAULT);
        FlowRuleManager.loadRules(Collections.singletonList(flowRule));
    }
}
