package com.example.demo.controller;

import com.example.demo.Entity.Configures;
import com.example.demo.mapper.ConfiguresMapper;
import com.example.demo.util.Redis.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Created by FengXinXin on 2018/4/16.
 */
@RestController
@RequestMapping("/test")
public class TestController{
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);
    @Autowired
    private RedisService redisService;
    @Autowired
    private ConfiguresMapper configuresMapper;

    @RequestMapping(value = {"/", ""})
    public String hellTask() {

        String value = redisService.get("ket");

        logger.info(Configures.map.get("spring.redis.host"));
        logger.info(Configures.map.get("spring.redis.port"));
        logger.info("map1:----"+Configures.map1.get("spring.redis.port"));

        List<Configures> list = configuresMapper.getListByServer("server1");

        return "value : "+ value;
    }
}
