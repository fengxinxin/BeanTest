package com.example.demo.util.Redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by FengXinXin on 2018/4/17.
 */
@Service
public class RedisService {
    private static final Logger logger = LoggerFactory.getLogger(RedisService.class);
    @Autowired
    private JedisPool jedisPool;

    public String get(String key) {
        Jedis jedis = null;
        String result = null;
        try {
            jedis = jedisPool.getResource();
            String str = jedis.get(key);
            logger.info("Redis get success - " + key + ", value:" + str);
            result = str;
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return result;
    }
}
