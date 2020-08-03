package hu.springcloud.feign.server.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * IP地址 查询结果对象
 * </p>
 *
 *
 * @date 2019-10-11
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "IpQueryVo对象", description = "IP地址查询参数")
public class IpQueryVo implements Serializable {

    private static final long serialVersionUID = -1997837206909075822L;
    private String ipStart;

    private String ipEnd;

    private String area;

    private String operator;

    private Long id;

    private Long ipStartNum;

    private Long ipEndNum;

}