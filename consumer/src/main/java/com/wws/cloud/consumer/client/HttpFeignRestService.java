package com.wws.cloud.consumer.client;

import com.wws.cloud.consumer.common.HttpFeignRestServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Administrator on 2020/3/10.
 *
 * @author wws
 * * TODO -----------TEST
 */
//@FeignClient(name = "spring-cloud-alibaba-dubbo-server", fallbackFactory = EchoServiceFallback.class, configuration = FeignConfiguration.class)
@FeignClient(name = "spring-cloud-alibaba-dubbo-server", fallbackFactory = HttpFeignRestServiceFallbackFactory.class)
public interface HttpFeignRestService {
    @GetMapping(value = "/feign/param")
    String param(@RequestParam("param") String param);

    @PostMapping("/feign/save")
    String save(@RequestParam("a") int a, @RequestParam("b") int b);

    @GetMapping("/sentinel/hello")
    String hello();
}

/*class FeignConfiguration {
    @Bean
    public EchoServiceFallback echoServiceFallback() {
        return new EchoServiceFallback();
    }
}

class EchoServiceFallback implements HttpFeignRestService {

    //有异常就进入降级？
    @Override
    public String param(String param) {
        return "echo fallback";
    }

    @Override
    public String save(int a, int b) {
        return "echo fallback";
    }

    @Override
    public String hello() {
        return "echo fallback";
    }

}*/
