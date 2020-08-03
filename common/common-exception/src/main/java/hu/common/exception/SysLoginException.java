
package hu.common.exception;

/**
 * 系统登录异常
 *
 * @date 2019-08-04
 */
public class SysLoginException extends SpringBootException {

    public SysLoginException(String message) {
        super(message);
    }
    public SysLoginException(Integer errorCode, String message) {
        super(errorCode,message);
    }

}
