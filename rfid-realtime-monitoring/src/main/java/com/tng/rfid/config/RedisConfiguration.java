package com.tng.rfid.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfiguration {

    /*
    @Value("${redis.hostName}")
    private String redisHostName;

    @Value("${redis.port}")
    private int redisPort;
    */

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        String redisHostName = "127.0.0.1";
        int redisPort = 6379;
        System.out.println(String.format("Redis host name: %s, redis port: %s", redisHostName, redisPort));
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(redisHostName, redisPort);
        return new JedisConnectionFactory(redisStandaloneConfiguration);
    }

    @Bean
    RedisTemplate<String, String> redisTemplate() {
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        return redisTemplate;
    }
}
