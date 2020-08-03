package hu.common.mybatis.plugin;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.Properties;

/**
 * @description:
 * @version: 2.0, 2019-11-05 11:16
 * @author: liujinhu
 */
@Intercepts({@Signature(type = Executor.class,
        method = "update",
        args = {MappedStatement.class, Object.class})})
public class EntityUpdateBeforeInterceptor implements Interceptor {


    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        int size = 2;
        // 这个判断可以不要，因为 注解当中 只拦截了Executor
        // 拦截 Executor 的 update 方法 生成sql前将 tenantId 设置到实体中
        // 当然 我们也可以不用 instanceof 的方法，我们可以在 类上面的注解的 args 当中指定
        if (invocation.getTarget() instanceof Executor && invocation.getArgs().length == size) {
            // Executor 的第一个参数是 ms
            MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
            SqlCommandType sqlCommandType = mappedStatement.getSqlCommandType();
            if (SqlCommandType.INSERT.equals(sqlCommandType)) {
                setDefaultValue(invocation, CreatedDate.class);
            } else if (SqlCommandType.UPDATE.equals(sqlCommandType)) {
                setDefaultValue(invocation, LastModifiedDate.class);
            }
        }
        return invocation.proceed();
    }

    private <T extends Annotation> void setDefaultValue(Invocation invocation, Class<T> dateField) throws NoSuchFieldException, IllegalAccessException {
        // Executor 的第二个参数是 param,得到参数
        Object object = invocation.getArgs()[1];
        // 原对象要声明  属性  updateDate
        Field[] fields = object.getClass().getDeclaredFields();
        Date currentDate = new Date(System.currentTimeMillis());
        for (Field field : fields) {
            T fieldAnnotation = field.getAnnotation(dateField);
            if (fieldAnnotation != null) {
                Field fieldModifyTime = object.getClass().getDeclaredField(field.getName());
                fieldModifyTime.setAccessible(true);
                fieldModifyTime.set(object, currentDate);
            }
        }
    }

    @Override
    public Object plugin(Object target) {
        //没什么特殊要求的话就注册到插件链里面
        return Plugin.wrap(target, this);
        // return null;
    }

    /**
     * 对属性进行配置
     *
     * @param properties
     */
    @Override
    public void setProperties(Properties properties) {

    }
}