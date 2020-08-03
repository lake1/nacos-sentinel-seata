
package hu.common.util;

import java.util.UUID;

/**
 * @author liujinhu
 * @date 2019-11-06
 */
public class UUIDUtil {

    public static String getUUID(){
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        return uuid;
    }
    
}
