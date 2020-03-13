package com.wws.cloud.consumer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Administrator on 2020/3/10.
 *
 * @author wws
 * * TODO -----------TEST
 */
@FeignClient("spring-cloud-alibaba-dubbo-server")
public interface HttpFeignRestService {
    @GetMapping(value = "/feign/param")
    String param(@RequestParam("param") String param);

    @PostMapping("/feign/save")
    String save(@RequestParam("a") int a, @RequestParam("b") int b);
}
