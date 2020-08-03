
package hu.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author liujinhu
 * @date 2018-11-08
 */
public class DateUtil {

    public static final String FORMATSTR_YYYYMMDDHHMMSSS_ = "yyyyMMddHHmmss";
    public static final String FORMATSTR_YYYYMMDDHHMMSSS = "yyyy-MM-dd HH:mm:ss.S";
    public static final String FORMATSTR_YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMATSTR_YYYYMMDDHHMM = "yyyy-MM-dd HH:mm";
    public static final String FORMATSTR_YYYYMMDDHH = "yyyy-MM-dd HH";
    public static final String FORMATSTR_YYYYMMDD = "yyyy-MM-dd";
    public static final String FORMATSTR_YYYY = "yyyy";
    public static final String FORMATSTR_YYYY_MM_DD = "yyyyMMdd";
    public static final String FORMATSTR_YYYYMMDDDELIMITER = "-";

    public static String getYYYYMMDDHHMMSS(Date date){
        if (date == null){
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = simpleDateFormat.format(date);
        return dateString;
    }
}
