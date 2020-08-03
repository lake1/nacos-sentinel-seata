
package hu.common.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * 密码加密工具类
 *
 * @author liujinhu
 * @date 2019-11-06
 */
@Slf4j
public class PasswordUtil {
    private static final String KEY = "666666";

    public static String encrypt(String pwd) {
        if (StringUtils.isBlank(pwd)) {
            return null;
        }
        return DigestUtils.sha256Hex(KEY + pwd);
    }

}
