
package hu.common.exception;

/**
 * DAO异常
 * @author
 * @date 2018-11-08
 */
public class DaoException extends SpringBootException {

    public DaoException(String message) {
        super(message);
    }
    public DaoException(Integer errorCode, String message) {
        super(errorCode,message);
    }

}
