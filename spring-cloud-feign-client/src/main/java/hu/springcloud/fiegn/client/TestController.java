package hu.springcloud.fiegn.client;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import hu.springcloud.feign.server.api.IpService;
import hu.springcloud.feign.server.vo.IpQueryVo;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @version: 2.0, 2019-10-31 10:03
 * @author: liujinhu
 */
@RestController
@RefreshScope
public class TestController {

    @Autowired
    private IpService ipService;

    @Value(value = "${name.abc:123}")
    private String nameAbc;
    @NacosValue(value = "${name.abc:123}", autoRefreshed = true)
    private String nameAbc1;


    private Logger logger = LoggerFactory.getLogger(TestController.class);

    @GetMapping("test")
    @SentinelResource("test")
    public String testFeign() {
        logger.warn("1111");
        return ipService.test();
    }

    //
//    @GetMapping("getIpById")
//    public IpQueryVo getIpById() {
//        logger.warn("1111");
//        return ipService.getIpById(89);
//    }
//
    @GetMapping("save")
    @GlobalTransactional
    public String save() {
        logger.warn("1111");
        IpQueryVo ip = new IpQueryVo();
        ip.setIpStart("1");
        ip.setIpEnd("10");
        ip.setArea("east");
        ip.setOperator("hu");
        ip.setIpStartNum(1L);
        ip.setIpEndNum(100L);
        ipService.save(ip);

        return "ok";
    }

    @GetMapping("save1")
    @GlobalTransactional
    public String save1() {
        logger.warn("1111");
        IpQueryVo ip = new IpQueryVo();
        ip.setIpStart("1");
        ip.setIpEnd("10");
        ip.setArea("east");
        ip.setOperator("hu");
        ip.setIpStartNum(1L);
        ip.setIpEndNum(100L);
        ipService.save(ip);
       
        System.out.println(RootContext.getXID());
        throw new RuntimeException("aa");
    }

}
