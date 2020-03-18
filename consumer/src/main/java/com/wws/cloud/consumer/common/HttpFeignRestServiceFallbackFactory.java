package com.wws.cloud.consumer.common;

import com.wws.cloud.consumer.client.HttpFeignRestService;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2020/3/16.
 *
 * @author wws
 */
@Slf4j
@Component
public class HttpFeignRestServiceFallbackFactory implements FallbackFactory<HttpFeignRestService> {

    @Override
    public HttpFeignRestService create(Throwable cause) {

        return new HttpFeignRestService() {
            @Override
            public String param(String param) {
                // 自定义限流、降级发生时的处理逻辑
                log.warn("远程调用被限流/降级了", cause);
                return "fallback";
            }

            @Override
            public String save(int a, int b) {
                // 自定义限流、降级发生时的处理逻辑
                log.warn("远程调用被限流/降级了", cause);
                return "fallback";
            }

            @Override
            public String hello() {
                // 自定义限流、降级发生时的处理逻辑
                log.warn("远程调用被限流/降级了", cause);
                return "fallback";
            }

        };
    }
}