
package hu.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 自定义异常
 *
 * @date 2018-11-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SpringBootException extends RuntimeException{
    private Integer errorCode;
    private String message;

    public SpringBootException(String message) {
        super(message);
        this.message = message;
    }

    public SpringBootException(Integer errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
        this.message = message;
    }
}
