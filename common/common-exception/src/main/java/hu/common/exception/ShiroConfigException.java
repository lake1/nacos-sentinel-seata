
package hu.common.exception;

/**
 * Shiro配置异常
 *
 *
 * @date 2019-09-29
 * @since 1.3.0.RELEASE
 **/
public class ShiroConfigException extends SpringBootException {

    public ShiroConfigException(String message) {
        super(message);
    }

    public ShiroConfigException(Integer errorCode, String message) {
        super(errorCode, message);
    }

}
