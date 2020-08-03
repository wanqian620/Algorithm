package com.example.service;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.handler.codec.json.JsonObjectDecoder;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: wanqian
 * @Date: 2020/7/9 16:55
 */
@Component
public class RedisMsgService {

    public void receiveMessage(String json) {
//        String s = JSONObject.toJSONString(jsonArray);
        //这个container 可以添加多个 messageListener
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        Object deserialize = jackson2JsonRedisSerializer.deserialize(json.getBytes());
//        JSONObject.toJSONString(deserialize);
        List<SmartMonitorHostDTO> smartMonitorHostDTOS = JSONObject.parseArray(deserialize.toString(), SmartMonitorHostDTO.class);
//        List<SmartMonitorHostDTO> smartMonitorHostDTOS = JSONObject.parseArray(jsonArray.toString(), SmartMonitorHostDTO.class);
        System.out.println(smartMonitorHostDTOS);
    }

}
