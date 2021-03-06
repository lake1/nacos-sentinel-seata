package hu.springcloud.feign.server.param;


import hu.common.query.QueryParam;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * SystemUser 查询参数对象
 * </p>
 *
 *
 * @date 2019-10-11
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SysUserQueryParam对象", description = "SystemUser查询参数")
public class SysUserQueryParam extends QueryParam {
    private static final long serialVersionUID = 1L;
}
