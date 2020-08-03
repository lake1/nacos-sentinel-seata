/*
 * Copyright 2019-2029 geekidea(https://github.com/geekidea)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package hu;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import com.alibaba.nacos.spring.context.annotation.discovery.EnableNacosDiscovery;
import hu.common.mybatis.plugin.EntityUpdateBeforeInterceptor;
import hu.common.mybatis.plugin.PrintSqlParamInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;


/**
 * spring-cloud-plus 项目启动入口
 *
 * @since 2018-11-08
 */
@EnableTransactionManagement
@EnableConfigurationProperties
@SpringBootApplication
@Import(value = {EntityUpdateBeforeInterceptor.class, PrintSqlParamInterceptor.class})
@EnableCaching
@MapperScan(basePackages = "hu.springcloud.feign.server.mapper")
@EnableNacosDiscovery
@NacosPropertySource(dataId = "spring-cloud-feign-server", autoRefreshed = true)
public class SpringCloudFeignServerApplication {

    public static void main(String[] args) {
        // 启动spring-cloud-plus
        ConfigurableApplicationContext context = SpringApplication.run(SpringCloudFeignServerApplication.class, args);
        // 打印项目信息
//        PrintApplicationInfo.print(context);
    }

}
