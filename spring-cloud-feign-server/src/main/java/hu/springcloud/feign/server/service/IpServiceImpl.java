package hu.springcloud.feign.server.service;

import hu.springcloud.feign.server.api.IpService;
import hu.springcloud.feign.server.entity.Ip;
import hu.springcloud.feign.server.mapper.IpMapper;
import hu.springcloud.feign.server.vo.IpQueryVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.skywalking.apm.toolkit.trace.ActiveSpan;
import org.apache.skywalking.apm.toolkit.trace.Trace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;


/**
 * <p>
 * IP地址 服务实现类
 * </p>
 *
 *
 * @since 2019-10-11
 */
@Slf4j
@RestController
public class IpServiceImpl implements IpService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private IpMapper ipMapper;

    @Override
    @Transactional
    public IpQueryVo getIpById(Integer id) {
        return ipMapper.getIpById(id);
    }

    @Override
    @Trace(operationName = "测试")
    public String test() {
        ActiveSpan.info("test111");
        return "1234";
    }

    @Override
    @Transactional
    public String save(IpQueryVo ipQueryVo) {
        Ip ip = new Ip();
        ip.setIpStart(ipQueryVo.getIpStart());
        ip.setIpEnd(ipQueryVo.getIpEnd());
        ip.setArea(ipQueryVo.getArea());
        ip.setOperator(ipQueryVo.getOperator());
        ip.setId(ipQueryVo.getId());
        ip.setIpStartNum(ipQueryVo.getIpStartNum());
        ip.setIpEndNum(ipQueryVo.getIpEndNum());

        ipMapper.insert(ip);
        System.out.println("111");
        return "111";
    }

    @Override
    public String save1(IpQueryVo ipQueryVo) {
        Ip ip = new Ip();
        ip.setIpStart(ipQueryVo.getIpStart());
        ip.setIpEnd(ipQueryVo.getIpEnd());
        ip.setArea(ipQueryVo.getArea());
        ip.setOperator(ipQueryVo.getOperator());
        ip.setId(ipQueryVo.getId());
        ip.setIpStartNum(ipQueryVo.getIpStartNum());
        ip.setIpEndNum(ipQueryVo.getIpEndNum());

        ipMapper.insert(ip);
        throw new RuntimeException("异常");
    }


}
