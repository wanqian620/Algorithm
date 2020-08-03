package com.example.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.dao.SmartMonitorHostDTO;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wanqian
 * @Date: 2020/7/9 19:17
 */
@EnableScheduling
@Component
public class MessageSender {


    @Autowired
    private RedisTemplate redisTemplate;

//    @Autowired
//    @Scope("prototype")
//    public void setRedisTemplate(RedisTemplate redisTemplate) {
//        redisTemplate.setValueSerializer(new StringRedisSerializer());
//        this.redisTemplate = redisTemplate;
//    }


    @Scheduled(fixedRate = 10 * 1000)
    public void sendMessage() {
        ArrayList<SmartMonitorHostDTO> list = new ArrayList<>();
        SmartMonitorHostDTO test1 = SmartMonitorHostDTO.builder()
                .id(1)
                .ip("127.0.0.1").build();
        list.add(test1);
        SmartMonitorHostDTO test2 = SmartMonitorHostDTO.builder()
                .id(2)
                .ip("127.0.0.2").build();
        list.add(test2);
//        Jackson2JsonRedisSerializer seria = new Jackson2JsonRedisSerializer(SmartMonitorHostDTO.class);
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        seria.setObjectMapper(objectMapper);
//        FastJsonRedisSerializer fastJsonRedisSerializer = new FastJsonRedisSerializer(SmartMonitorHostDTO.class);
//        byte[] serialize = fastJsonRedisSerializer.serialize(test1);
        String s = JSONObject.toJSONString(list);
//        Object deserialize = seria.deserialize(s.getBytes());
        redisTemplate.convertAndSend("test", s);
    }

}
