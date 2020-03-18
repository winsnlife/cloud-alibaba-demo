package com.wws.cloud.provider.service.impl;

import com.wws.cloud.facade.service.DubboEchoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * Created by Administrator on 2020/3/11.
 *
 * @author wws
 */
@Slf4j
@Service(protocol = "rest")
@Path("ds")
public class DubboEchoServiceImpl2 implements DubboEchoService {
    @Override
//    @SentinelResource("dubboEcho")
    @Path("echo")
    @Produces({APPLICATION_JSON})
    @Consumes({APPLICATION_JSON})
    public String echo(String message) {
        log.info("yes wws echo hello!");
        return "[echo] Hello, " + message;
    }

}
