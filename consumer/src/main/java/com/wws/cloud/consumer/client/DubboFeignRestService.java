package com.wws.cloud.consumer.client;

import com.alibaba.cloud.dubbo.annotation.DubboTransported;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Administrator on 2020/3/10.
 *
 * @author wws
 *
 */
@FeignClient("spring-cloud-alibaba-dubbo-server")
@DubboTransported(protocol = "dubbo")
public interface DubboFeignRestService {
    @GetMapping(value = "/param")
    String param(@RequestParam("param") String param);

    @PostMapping("/save")
    String saveB(@RequestParam("a") int a, @RequestParam("b") int b);
}