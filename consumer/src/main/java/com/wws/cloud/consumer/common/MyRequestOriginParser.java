package com.wws.cloud.consumer.common;

import com.alibaba.csp.sentinel.adapter.servlet.callback.RequestOriginParser;
import com.alibaba.nacos.client.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2020/3/16.
 *
 * @author wws
 * 扩展 - 实现区分来源

当配置流控规则或授权规则时，若需要针对调用来源进行限流，得先实现来源的区分，
Sentinel提供了RequestOriginParser接口来处理来源。只要Sentinel保护的接口资源被访问
，Sentinel就会调用RequestOriginParser的实现类去解析访问来源。
 */
@Slf4j
//@Component
public class MyRequestOriginParser implements RequestOriginParser {

    @Override
    public String parseOrigin(HttpServletRequest request) {
        // 从header中获取名为 origin 的参数并返回
        String origin = request.getHeader("origin");
        if (StringUtils.isBlank(origin)) {
            // 如果获取不到，则抛异常
            String err = "origin param must not be blank!";
            log.error("parse origin failed: {}", err);
            throw new IllegalArgumentException(err);
        }

        return origin;
    }
}