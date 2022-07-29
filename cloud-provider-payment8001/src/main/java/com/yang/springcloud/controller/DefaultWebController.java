package com.yang.springcloud.controller;

import cn.hutool.core.util.StrUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultWebController {

    Logger clientLogger = LoggerFactory.getLogger(this.getClass());

    @Value("${server.application.name}")
    private String name;

    @Value("${server.port}")
    private String port;

    @RequestMapping("/")
    public String thotweb() {
        return StrUtil.format("{} {}", name, port);
    }

}
