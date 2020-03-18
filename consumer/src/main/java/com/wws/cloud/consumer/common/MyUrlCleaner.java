package com.wws.cloud.consumer.common;

import com.alibaba.csp.sentinel.adapter.servlet.callback.UrlCleaner;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by Administrator on 2020/3/16.
 *
 * @author wws
 * 实现该接口可以让我们对来源url进行编辑并返回，
 * 这样就可以将RESTful URL里动态的路径转换为占位符之类的字符串
 */
@Slf4j
@Component
public class MyUrlCleaner implements UrlCleaner {

    @Override
    public String clean(String originUrl) {
        String[] split = originUrl.split("/");

        // 将数字转换为特定的占位标识符
        return Arrays.stream(split)
                .map(s -> NumberUtils.isNumber(s) ? "{number}" : s)
                .reduce((a, b) -> a + "/" + b)
                .orElse("");
    }
}