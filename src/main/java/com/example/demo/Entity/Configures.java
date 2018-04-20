package com.example.demo.Entity;

import com.example.demo.mapper.ConfiguresMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by FengXinXin on 2018/4/16.
 */
@Component
public class Configures {
    private static final Logger logger = LoggerFactory.getLogger(Configures.class);

    public static Map<String, String> map = new HashMap<>();
    public static Map<String, String> map1 = new HashMap<>();

    @Autowired
    private ConfiguresMapper configuresMapper;

    public Integer id;
    public String server;
    public String name;
    public String value;

    public Configures() {
    }

    @Autowired
    public Configures(ConfiguresMapper configuresMapper1) {
        Map<String, String> mapC = new HashMap<>();
        List<Configures> list = configuresMapper1.getAll();
        if (list != null && list.size() != 0) {
            list.forEach(obj -> mapC.put(obj.name, obj.value));
            this.map1 = mapC;
            logger.info("ConfiguresBean is Success");
        } else {
            logger.error("ConfiguresBean error : Map is null !!!");
        }
    }

    @Bean
    public Configures getConfiguresBean() {
        Configures configures = new Configures();
        Map<String, String> map = new HashMap<>();
        List<Configures> list = configuresMapper.getAll();
        if (list != null && list.size() != 0) {
            list.forEach(obj -> map.put(obj.name, obj.value));
            Configures.map = map;
            logger.info("ConfiguresBean is Success");
        } else {
            logger.error("ConfiguresBean error : Map is null !!!");
        }
        return configures;
    }

}
