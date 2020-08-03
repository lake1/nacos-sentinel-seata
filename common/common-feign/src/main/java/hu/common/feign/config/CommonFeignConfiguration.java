package hu.common.feign.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Request;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @version: 2.0, 2019-11-14 09:35
 * @author: liujinhu
 */
public class CommonFeignConfiguration {

    /**
     * Feign 客户端的日志记录，默认级别为NONE
     * Logger.Level 的具体级别如下：
     * NONE：不记录任何信息
     * BASIC：仅记录请求方法、URL以及响应状态码和执行时间
     * HEADERS：除了记录 BASIC级别的信息外，还会记录请求和响应的头信息
     * FULL：记录所有请求与响应的明细，包括头信息、请求体、元数据
     */
    @Bean
    feign.Logger.Level gitHubFeignLoggerLevel() {
        return feign.Logger.Level.FULL;
    }

    @Bean
    Request.Options feignOptions() {
        return new Request.Options(4 * 1000, TimeUnit.MILLISECONDS, 12 * 1000, TimeUnit.MILLISECONDS, true);
    }

    @Bean
    public ErrorDecoder errorDecoder() {
        return new UserErrorDecoder();
    }

    /**
     * 自定义错误
     */
    public class UserErrorDecoder implements ErrorDecoder {
        private Logger logger = LoggerFactory.getLogger(getClass());
        ObjectMapper objectMapper = new ObjectMapper();

        @Override
        public Exception decode(String methodKey, Response response) {
//            try {
//                Reader reader = response.body().asReader();
////                objectMapper.reader(reader)
//                String toString = Util.toString(reader);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//                    log.error(body);
//            ExceptionInfo ei = this.objectMapper.readValue(response.b.getBytes("UTF-8"), ExceptionInfo.class);
//                    Class clazz = Class.forName(ei.getException());
//                    Object obj = clazz.newInstance();
//                    String message = ei.getMessage();
//                    if (obj instanceof BusinessException) {
//                        targetMsg = message.substring(message.indexOf("{"), message.indexOf("}") + 1);
//                        FeignException businessException = JsonUtil.toObj(targetMsg, FeignException.class);
//                        return businessException;
//                    } else {
//                        targetMsg = message.substring(message.indexOf(":"), message.length());
            return feign.FeignException.errorStatus(methodKey, response);
        }

    }
}