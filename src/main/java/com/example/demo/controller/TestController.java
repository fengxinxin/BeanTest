package com.example.demo.controller;

import com.example.demo.Entity.Configures;
import com.example.demo.util.Redis.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by FengXinXin on 2018/4/16.
 */
@RestController
@RequestMapping("/test")
public class TestController{
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);
    @Autowired
    private RedisService redisService;

    @RequestMapping(value = {"/", ""})
    public String hellTask() {

        String value = redisService.get("ket");

        logger.info(Configures.map.get("spring.redis.host"));
        logger.info(Configures.map.get("spring.redis.port"));

        return "value : "+ value;
    }
}
