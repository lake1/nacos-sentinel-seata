package hu.common.cache.redis.ops;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;

/**
 * @description: redis 操作
 * @version: 2.0, 2019-12-02 13:55
 * @author: liujinhu
 */
@Component
public class RedisOps {

    @Autowired
    private RedisTemplate redisTemplate;


    public RedisTemplate getRedisTemplate() {
        return redisTemplate;
    }

    public HyperLogLogOperations hyperLogLogOperations() {
        return redisTemplate.opsForHyperLogLog();
    }


    public ListOperations listOperations() {
        return redisTemplate.opsForList();
    }

    public SetOperations setOperations() {
        return redisTemplate.opsForSet();
    }

    public ZSetOperations<String, Object> zSetOperations() {
        return redisTemplate.opsForZSet();
    }

    public ValueOperations valueOperations() {
        return redisTemplate.opsForValue();
    }

}
