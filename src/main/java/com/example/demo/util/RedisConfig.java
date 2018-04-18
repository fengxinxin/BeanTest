package com.example.demo.util;

import com.example.demo.Entity.Configures;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by FengXinXin on 2018/4/17.
 */
@Configuration
@EnableAutoConfiguration
public class RedisConfig {
    private static final Logger logger = LoggerFactory.getLogger(RedisConfig.class);

    @Bean
    public JedisPoolConfig getRedisConfig() {
        JedisPoolConfig config = new JedisPoolConfig();
        return config;
    }

    @Bean
    @DependsOn("getConfiguresBean")
    public JedisPool getJedisPool() {
        JedisPoolConfig config = getRedisConfig();
        logger.info("---------" + Configures.map.get("spring.redis.host"));
        logger.info("---------" + Configures.map.get("spring.redis.port"));
        JedisPool jp = new JedisPool(config, Configures.map.get("spring.redis.host"),
                Integer.parseInt(Configures.map.get("spring.redis.port")));
        return jp;
    }
}
