
package hu.common.util;

import cn.hutool.http.useragent.UserAgent;
import cn.hutool.http.useragent.UserAgentUtil;
import hu.common.vo.ClientInfo;
import hu.common.vo.DeviceInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 *  用户客户端信息工具类
 * </p>
 * @author liujinhu
 * @date 2019-05-24
 **/
public class ClientInfoUtil {

    /**
     * 获取用户客户端信息
     * @param request
     * @return
     */
    public static ClientInfo get(HttpServletRequest request){
        String userAgent = request.getHeader("User-Agent");
        return get(userAgent);
    }

    /**
     * 获取用户客户端信息
     * @param userAgentString
     * @return
     */
    public static ClientInfo get(String userAgentString){
        ClientInfo clientInfo = new ClientInfo();

        UserAgent userAgent = UserAgentUtil.parse(userAgentString);

        // 浏览器名称
        clientInfo.setBrowserName(userAgent.getBrowser().getName());
        // 浏览器版本
        clientInfo.setBrowserversion(userAgent.getVersion());
        // 浏览器引擎名称
        clientInfo.setEngineName(userAgent.getEngine().getName());
        // 浏览器引擎版本
        clientInfo.setEngineVersion(userAgent.getEngineVersion());
        // 用户操作系统名称
        clientInfo.setOsName(userAgent.getOs().getName());
        // 用户操作平台名称
        clientInfo.setPlatformName(userAgent.getPlatform().getName());
        // 是否是手机
        clientInfo.setMobile(userAgent.isMobile());

        // 获取移动设备名称和机型
        DeviceInfo deviceInfo = getDeviceInfo(userAgentString);
        // 设置移动设备名称和机型
        clientInfo.setDeviceName(deviceInfo.getName());
        clientInfo.setDeviceModel(deviceInfo.getModel());

        // ip
        clientInfo.setIp(IpUtil.getRequestIp());

        return clientInfo;
    }

    private static String USERAGENT = ";\\s?(\\S*?\\s?\\S*?)\\s?Build/(\\S*?)[;)]";
    private static String DEVICEINFO_PATTERN = ";\\s?(\\S*?\\s?\\S*?)\\s?\\)";
    /**
     * 获取移动端用户设备的名称和机型
     * @param userAgentString
     * @return
     */
    public static DeviceInfo getDeviceInfo(String userAgentString) {
        DeviceInfo deviceInfo = new DeviceInfo();
        try {
            Pattern pattern = Pattern.compile(USERAGENT);
            Matcher matcher = pattern.matcher(userAgentString);
            String model = null;
            String name = null;

            if (matcher.find()) {
                model = matcher.group(1);
                name = matcher.group(2);
            }

            if (model == null && name == null){
                pattern = Pattern.compile(DEVICEINFO_PATTERN);
                matcher = pattern.matcher(userAgentString);
                if (matcher.find()) {
                    model = matcher.group(1);
                }
            }
           
            deviceInfo.setName(name);
            deviceInfo.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deviceInfo;
    }
}
