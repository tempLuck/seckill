package com.example.seckill.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author by liuguangjin
 * @Description TODO
 * @Date 21/5/22
 */
@Configuration
public class RedisConfig {
    @Bean
    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<String,Object> redisTemplate= new RedisTemplate<>();

        //Key 序列化
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //value 序列化
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());

        //hash类型 Key 序列化
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        //hash类型 value 序列化
        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());




        //   注入连接工厂
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }
}