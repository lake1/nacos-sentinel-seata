package hu.springcloud.feign.server.mapper;

import hu.springcloud.feign.server.entity.Ip;
import hu.springcloud.feign.server.vo.IpQueryVo;
import tk.mybatis.mapper.common.Mapper;

import java.io.Serializable;

/**
 * <p>
 * IP地址 Mapper 接口
 * </p>
 *
 *
 * @since 2019-10-11
 */
public interface IpMapper extends Mapper<Ip> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    IpQueryVo getIpById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param ipQueryParam
     * @return
     */
//    IPage<IpQueryVo> getIpPageList(@Param("page") Page page, @Param("param") IpQueryParam ipQueryParam);

}
