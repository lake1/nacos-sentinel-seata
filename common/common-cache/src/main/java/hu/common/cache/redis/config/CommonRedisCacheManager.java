package hu.common.cache.redis.config;

import com.google.common.collect.Sets;
import hu.common.cache.redis.bean.KeyDuration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * spring boot data redis 配置
 *
 * @Cacheable(key = "#name", cacheNames = "test")
 * <p>
 * 对应的cacheNames配置过期时间 每个项目自定义配置
 * @description:
 * @version: 2.0, 2019-12-02 15:45
 * @author: liujinhu
 */

public abstract class CommonRedisCacheManager {

    @Bean
    public RedisCacheManager cacheManager(RedisConnectionFactory factory) {
        Set<KeyDuration> keyDurations = Sets.newHashSet();
        keyDurations(keyDurations);
        return new RedisCacheManager(RedisCacheWriter.nonLockingRedisCacheWriter(factory),
                RedisCacheConfiguration.defaultCacheConfig(), forEachKeyDuration(keyDurations));

    }


    public abstract void keyDurations(Set<KeyDuration> keyDurations);

    private Map<String, RedisCacheConfiguration> forEachKeyDuration(Set<KeyDuration> durations) {
        return durations.stream().collect(Collectors.toMap(KeyDuration::getKey, keyDuration
                -> RedisCacheConfiguration.defaultCacheConfig().entryTtl(keyDuration.getDuration())));
    }
}
