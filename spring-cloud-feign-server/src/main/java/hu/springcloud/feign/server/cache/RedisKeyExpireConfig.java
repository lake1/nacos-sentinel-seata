//package hu.springcloud.feign.server.cache;
//
//import hu.common.cache.redis.bean.KeyDuration;
//import hu.common.cache.redis.config.CommonRedisCacheManager;
//import org.springframework.stereotype.Component;
//
//import java.time.Duration;
//import java.util.Set;
//
///**
// * 自定义 key过期时间
// * example: key 为cacheNames值
// *
// * @Cacheable(key = "#name", cacheNames = "test")
// * @description:
// * @version: 2.0, 2019-12-02 15:06
// * @author: liujinhu
// */
//@Component
//public class RedisKeyExpireConfig extends CommonRedisCacheManager {
//
//
//    @Override
//    public void keyDurations(Set<KeyDuration> keyDurations) {
//        keyDurations.add(new KeyDuration("test", Duration.ofSeconds(10)));
//    }
//}
