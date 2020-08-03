package hu.springcloud.feign.server.api;


import hu.common.feign.config.CommonFeignConfiguration;
import hu.springcloud.feign.server.vo.IpQueryVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * IP地址 服务类
 * </p>
 *
 *
 * @since 2019-10-11
 */
@FeignClient(value = "spring-cloud-feign-server", configuration = CommonFeignConfiguration.class)
public interface IpService {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/getIpById/{id}")
    IpQueryVo getIpById(@PathVariable("id") Integer id);

    @RequestMapping(value = "/test", method= RequestMethod.GET)
    String test();

    @PostMapping(value = "/save")
    String save(@RequestBody IpQueryVo ipQueryParam);

    @PostMapping(value = "/save1")
    String save1(@RequestBody IpQueryVo ipQueryParam);

    /**
     * 获取分页对象
     *
     * @param ipQueryParam
     * @return
     */
//    Paging<IpQueryVo> getIpPageList(IpQueryParam ipQueryParam) throws Exception;

}
