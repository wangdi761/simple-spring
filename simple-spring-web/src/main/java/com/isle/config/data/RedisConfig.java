package com.isle.config.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * 配置redis
 * Created by 61066 on 2017/12/28.
 */
@Configuration
@PropertySource("classpath:database.properties")
public class RedisConfig {

    @Autowired
    private Environment environment;

    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory cf = new JedisConnectionFactory();
        String host = environment.getProperty("redis.host");
        int port = Integer.parseInt(environment.getProperty("redis.port"));
        cf.setHostName(host);
        cf.setPort(port);
        cf.afterPropertiesSet();
        return cf;
    }

    @Bean
    public RedisTemplate<String, String> redisTemplate(
            RedisConnectionFactory redisCF) {
        RedisTemplate<String, String> redisTemplate =
                new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisCF);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

}
