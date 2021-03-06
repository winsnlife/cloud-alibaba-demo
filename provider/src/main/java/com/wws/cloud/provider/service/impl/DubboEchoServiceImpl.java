package com.wws.cloud.provider.service.impl;

import com.wws.cloud.facade.service.DubboEchoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;

import javax.ws.rs.Path;

/**
 * Created by Administrator on 2020/3/11.
 *
 * @author wws
 */
@Slf4j
@Service
public class DubboEchoServiceImpl implements DubboEchoService {
    @Override
//    @SentinelResource("dubboEcho")
    public String echo(String message) {
        log.info("yes wws echo hello!");
        return "[echo] Hello, " + message;
    }

}
