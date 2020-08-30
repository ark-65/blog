package io.ark.hope.apiserver.controller;

import io.ark.hope.core.service.SaveTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author: ark
 * @Date: 2020/8/30 5:07 下午
 * @Description:
 */
@RestController
public class TestController {

    @Autowired
    SaveTest saveTest;
    @Resource
    RedisTemplate<String, String> redisTemplate;

    @GetMapping("/api/v1/test")
    public Map<String, String> testApi() {
        Map<String, String> testMap = new HashMap<>();
        testMap.put("test1", "test");
        saveTest.save();
        return testMap;
    }

    @GetMapping("/api/v1/redis")
    public void testRedis() {
//        saveTest.saveRedis();
    }
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        Map<String, String> testMap = new HashMap<>();
        testMap.put(name, "test");
        saveTest.save();
        redisTemplate.opsForValue().set(name, "4555", Duration.ofMinutes(1));
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
class Greeting {

    private final long id;
    private final String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}