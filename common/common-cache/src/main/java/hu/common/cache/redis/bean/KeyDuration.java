package hu.common.cache.redis.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;

/**
 * @description:
 * @version: 2.0, 2019-12-02 15:46
 * @author: liujinhu
 */
@Getter
@Setter
@AllArgsConstructor
public class KeyDuration {

    public String key;
    public Duration duration;
}
