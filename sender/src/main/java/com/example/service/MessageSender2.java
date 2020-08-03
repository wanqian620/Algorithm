//package com.example.service;
//
//import com.alibaba.fastjson.JSONObject;
//import com.example.dao.SmartMonitorHostDTO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @Author: wanqian
// * @Date: 2020/7/9 19:17
// */
//@EnableScheduling
//@Component
//public class MessageSender2 {
//
//
//    @Autowired
//    private RedisTemplate redisTemplate;
//
//
//    @Scheduled(fixedRate = 10 * 1000)
//    public void sendMessage() {
//        ArrayList<SmartMonitorHostDTO> list = new ArrayList<>();
//        SmartMonitorHostDTO test1 = SmartMonitorHostDTO.builder()
//                .id(3)
//                .ip("127.0.0.3").build();
//        list.add(test1);
//        SmartMonitorHostDTO test2 = SmartMonitorHostDTO.builder()
//                .id(4)
//                .ip("127.0.0.4").build();
//        list.add(test2);
////        FastJsonRedisSerializer fastJsonRedisSerializer = new FastJsonRedisSerializer(SmartMonitorHostDTO.class);
////        byte[] serialize = fastJsonRedisSerializer.serialize(test1);
//
//        String s = JSONObject.toJSONString(list);
//        List<SmartMonitorHostDTO> smartMonitorHostDTOS = JSONObject.parseArray(s, SmartMonitorHostDTO.class);
//        redisTemplate.convertAndSend("test", s);
//    }
//
//}
