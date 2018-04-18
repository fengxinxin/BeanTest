package com.example.demo;

import com.example.demo.Entity.Configures;
import com.example.demo.mapper.ConfiguresMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootApplication
public class DemoApplication {
    private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

    @Autowired
    private ConfiguresMapper configuresMapper;

//    @Bean
//    public RedisConfig getRedisConfigBean() {
//        List<Configures> list = configuresMapper.getListByKey("redis");
//        RedisConfig redisConfig = new RedisConfig();
//        //stream操作
//        List<Configures> hostList =
//                list.stream()
//                        .filter(Configures -> Configures.name.equals("host"))
//                        .collect(Collectors.toList());
//        List<Configures> portList =
//                list.stream()
//                        .filter(Configures -> Configures.name.equals("port"))
//                        .collect(Collectors.toList());
//        redisConfig.setHost(hostList.get(0).value);
//        redisConfig.setPort(Integer.parseInt(portList.get(0).value));
//        return redisConfig;
//    }

//    @Bean
//    public Configures getConfiguresBean() {
//        Configures configures = new Configures();
//        Map<String, String> map = new HashMap<>();
//        List<Configures> list = configuresMapper.getAll();
//        if (list != null && list.size() != 0) {
////            list.stream().map(obj -> map.put(obj.name, obj.value)).collect(Collectors.toList());
//            list.forEach(obj -> map.put(obj.name, obj.value));
//            Configures.map = map;
//        } else {
//            logger.error("Map is null!!!");
//        }
//        return configures;
//    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
