package com.tng.rfid.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path="/redisTest")
public class RedisController {

    private RedisTemplate<String, String> redisTemplate;
    private ValueOperations<String, String> valueOperations;
    private ObjectMapper objectMapper;

    public RedisController(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
        valueOperations = redisTemplate.opsForValue();
        objectMapper = new ObjectMapper();
    }

    @GetMapping(path="/save")
    public String save() throws JsonProcessingException {

        Employee m = new Employee();
        m.setName("zakir");

        Map<String, Employee> map = new HashMap<>();
        map.put("zakir", m);

        var str = objectMapper.writeValueAsString(map);
        valueOperations.set("info", str);
        return "saved";
    }

    @GetMapping(path="/get")
    public Employee getInfo() throws JsonProcessingException {

        Employee m = new Employee();
        m.setName("zakir");

        Map<String, Employee> map = new HashMap<>();
        map.put("zakir", m);

        var str = valueOperations.get("info");
        Map<String, Employee> info = objectMapper.readValue(str, new TypeReference<Map<String, Employee>>(){});
        return info.get("zakir");
    }

}

@Data
class Employee{
    private String name;
}
