package com.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Service
public class RedisPoolFactory {

    @Autowired
    RedisConfig redisConfig;

    @Bean
    public JedisPool JedisFactory() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(redisConfig.getPoolMaxTotal());
        jedisPoolConfig.setMaxIdle(redisConfig.getPoolMaxIdle());
        jedisPoolConfig.setMinIdle(redisConfig.getPoolMinIdle());
        jedisPoolConfig.setMaxWaitMillis(redisConfig.getPoolMaxWait() * 1000);
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, redisConfig.getHost(),
                redisConfig.getPort(), redisConfig.getTimeout() * 1000,
                redisConfig.getPassword(), redisConfig.getDatabase());
        return jedisPool;
    }
}