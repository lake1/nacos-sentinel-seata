
package hu.common.exception;

/**
 * 业务异常
 *
 * @date 2018-11-08
 */
public class BusinessException extends SpringBootException {

    public BusinessException(String message) {
        super(message);
    }
    public BusinessException(Integer errorCode, String message) {
        super(errorCode,message);
    }

}
